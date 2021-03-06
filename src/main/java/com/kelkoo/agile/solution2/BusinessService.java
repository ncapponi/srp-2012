package com.kelkoo.agile.solution2;

import com.kelkoo.agile.solution2.collaborators.Client;
import com.kelkoo.agile.solution2.collaborators.Product;

public class BusinessService {

    private CartRepository repository;

    public CartFacade getCartForClient(Client client) throws Exception {
        return CartFacade.find(client, repository);
    }

    public void addProduct(Client client, Product product) throws Exception {
        CartFacade cart = getCartForClient(client);
        cart.addProduct(product);
        cart.save();
    }

    public void sendMailTo(Client client) throws Exception {
        CartFacade cart = getCartForClient(client);
        String mailContent = cart.computeMailContent();
        MailService.sentMailTo(client, mailContent);
    }

    public void pay(Client client) throws Exception {
        CartFacade cart = getCartForClient(client);
        cart.validate();
    }

    // other services
    // ...
    
    private static class MailService {

        static void sentMailTo(Client client, String mailContent) {
            // Call mail server here
        }
    }
}
