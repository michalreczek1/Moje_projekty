package klient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Klient5_JsonTekstowo {

    public static void main(String[] args) {
        System.out.println("Startujemy...");
        Client client = ClientBuilder.newClient();
        
        WebTarget root = client.target(Ustawienia.URL_SERWERA);
        
        Response response = root
                .path("products")
                .request()
                .accept(MediaType.APPLICATION_JSON) // albo "application/json", można też bezp. w request(...)
                .buildGet()
                .invoke();

        System.out.println("Otrzymałem response: " + response);
        System.out.println("Status: " + response.getStatus());
        System.out.println("Content-Type: " + response.getMediaType());
        
        if(response.getStatus() != 200) {
            System.out.println("Chyba coś nie tak, więc przerywam.");
            return;
        }

        String trescOdpowiedzi = response.readEntity(String.class);
        System.out.println("Treść odpowiedzi:");
        System.out.println(trescOdpowiedzi);
        
        System.out.println("Gotowe");
    }

}












