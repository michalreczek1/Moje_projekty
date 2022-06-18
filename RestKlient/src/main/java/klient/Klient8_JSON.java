package klient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sklep.model.Product;

public class Klient8_JSON {

    public static void main(String[] args) {

        System.out.println("Startujemy...");
        Client client = ClientBuilder.newClient();
        
        WebTarget root = client.target(Ustawienia.URL_SERWERA);
        
        Response response = root
                .path("products/2")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke();

        System.out.println("Status: " + response.getStatus());
        System.out.println("Content-Type: " + response.getMediaType());
        
        if(response.getStatus() != 200) {
            System.out.println("Chyba coś nie tak, więc przerywam.");
            return;
        }

        Product product = response.readEntity(Product.class);
        System.out.println("Mam produkt: " + product);
    }

}



