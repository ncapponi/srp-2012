package com.kelkoo.agile.solution1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import com.kelkoo.agile.solution1.collaborators.Client;


public class TestPayment {
    @Test
    public void payIfClientIsSolvent() {
        Client client = mock(Client.class);
        when(client.isSolvent()).thenReturn(true);
        Cart cart = new Cart(client, mock(Date.class));
        Payment payment = new Payment();
        
        assertThat(payment.pay(client, cart), is(true));
    }

    @Test
    public void dontPayedIfClientIsNotSolvent() {
        Client client = mock(Client.class);
        when(client.isSolvent()).thenReturn(false);
        Cart cart = new Cart(client, mock(Date.class));
        Payment payment = new Payment();
                
        assertThat(payment.pay(client, cart), is(false));
    }
}
