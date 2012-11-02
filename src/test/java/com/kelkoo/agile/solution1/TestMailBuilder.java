package com.kelkoo.agile.solution1;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.kelkoo.agile.solution1.collaborators.Client;
import com.kelkoo.agile.solution1.collaborators.Product;


public class TestMailBuilder {
    @Test
    public void getMailContent() throws Exception {
        Client client = mock(Client.class);
        Date creationDate = mock(Date.class);
        when(creationDate.toString()).thenReturn("20121008");
        Cart cart = new Cart(client, creationDate);
        cart.addProduct(new Product("monProduit", 2.0f));

        String expectedContent = "Bonjour,\nVotre panier composé le 20121008 comporte les éléments suivants :\n- monProduit au prix de 2.0\n";
        MailBuilder mailBuilder = new MailBuilder();
        assertThat(mailBuilder.getMailContent(cart), Is.is(expectedContent));
    }

   
}
