package com.kelkoo.agile.solution2;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Test;

import com.kelkoo.agile.solution2.collaborators.Client;
import com.kelkoo.agile.solution2.collaborators.Product;

public class TestCartFacade {

    @Test
    public void addProduct() throws Exception {
        Cart cart = new Cart(mock(Client.class), mock(Date.class));
        CartRepository repository = mock(CartRepository.class);
        MailBuilder mailBuilder = mock(MailBuilder.class);
        Payment payment = mock(Payment.class);
        CartFacade cartFacade = new CartFacade(cart, repository, mailBuilder, payment);
        Product product = mock(Product.class);
        cartFacade.addProduct(product);
        assertThat(cartFacade.getProducts().size(), is(1));
        assertThat(cartFacade.getProducts().get(0), is(product));
    }
    
    @Test
    public void removeProduct() throws Exception {
        Cart cart = new Cart(mock(Client.class), mock(Date.class));
        CartRepository repository = mock(CartRepository.class);
        MailBuilder mailBuilder = mock(MailBuilder.class);
        Payment payment = mock(Payment.class);
        CartFacade cartFacade = new CartFacade(cart, repository, mailBuilder, payment);
        Product product = mock(Product.class);
        cartFacade.addProduct(product);
        Product product1 = mock(Product.class);
        cartFacade.addProduct(product1);
        cartFacade.removeProduct(product);
        assertThat(cartFacade.getProducts().size(), is(1));
        assertThat(cartFacade.getProducts().get(0), is(product1));
    }

}
