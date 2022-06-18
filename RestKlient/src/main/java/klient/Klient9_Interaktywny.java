package klient;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sklep.model.Product;

public class Klient9_Interaktywny {

    public static void main(String[] args) {
        System.out.println("Startujemy...");
        Scanner scanner = new Scanner(System.in);
        
        Client client = ClientBuilder.newClient();
        WebTarget path = client.target(Ustawienia.URL_SERWERA)
                .path("products")
                .path("{id}");
        
        System.out.println("Przygotowana ścieżka: " + path);

        while (true) {
            System.out.print("Podaj id: ");
            int id = scanner.nextInt();
            if(id == 0) break;
            
            Response response = path
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke();
            
            System.out.println("Status: " + response.getStatus());
            System.out.println("Content-Type: " + response.getMediaType());
            if (response.getStatus() == 200) {
                Product product = response.readEntity(Product.class);
                System.out.println("Mam produkt:");
                System.out.println("  Nazwa: " + product.getProductName());
                System.out.println("  Cena: " + product.getPrice());
                System.out.println("  Opis: " + product.getDescription());
                System.out.println();
            } else {
                System.out.println("nie mogę odczytać");
            }
        }
    }

}



