package com.kelkoo.agile.solution1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import com.kelkoo.agile.solution1.collaborators.Client;
import com.kelkoo.agile.solution1.collaborators.Database;
import com.kelkoo.agile.solution1.collaborators.Product;

public class TestCartRepository {

    @AfterClass
    public static void tearDown() {
        File directory = new File(".");
        FilenameFilter filter = cartFilterName();
        for (String fileToDelete : directory.list(filter)) {
            File file = new File(fileToDelete);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void save() throws IOException, ClassNotFoundException {
        Product product = new Product("monProduit", 1.0f);
        Cart cart = newCart(product);

        CartRepository cartRepository = newCartRepository();
        cartRepository.save(cart);

        Cart savedCart = readSavedCart();

        assertThat(savedCart.getProducts().size(), is(1));
        assertThat(savedCart.getProducts().get(0), is(product));
    }

    @Test
    public void find() throws Exception {
        Product product = new Product("monProduit", 1.0f);
        Cart cart = newCart(product);
        Integer clientId = 0;
        Client client = mock(Client.class);
        when(client.getId()).thenReturn(clientId);
        
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("cart"+clientId+".ser"));
        stream.writeObject(cart);
        stream.close();
        
        CartRepository cartRepository = newCartRepository();

        assertThat(cartRepository.find(client).getClientId(), is(clientId));
    }

    private CartRepository newCartRepository() {
        Database database = mock(Database.class);
        CartRepository cartRepository = new CartRepository(database);
        return cartRepository;
    }

    private Cart readSavedCart() throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("cart.ser"));
        Cart savedCart = (Cart) stream.readObject();
        stream.close();
        return savedCart;
    }

    private Cart newCart(Product product) {
        Cart cart = new Cart(new Client(), new Date());
        cart.addProduct(product);
        return cart;
    }
    
    private static FilenameFilter cartFilterName() {
        FilenameFilter filter = new FilenameFilter() {
            
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("cart") && name.endsWith(".ser");
            }
        };
        return filter;
    }
}
