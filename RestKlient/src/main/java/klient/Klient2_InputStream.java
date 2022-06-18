package klient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Klient2_InputStream {

    public static void main(String[] args) {
        System.out.println("Startujemy...");
        Client client = ClientBuilder.newClient();
        
        System.out.println("Przygotowuję zapytanie...");
        WebTarget target = client.target(Ustawienia.URL_SERWERA + "products");
        Invocation invocation = target.request().buildGet();
        
        System.out.println("Wysyłam zapytanie...");
        Response response = invocation.invoke();

        System.out.println("Otrzymałem response: " + response);
        System.out.println("Status: " + response.getStatus());
        System.out.println("Content-Type: " + response.getMediaType());
        
        if(response.getStatus() != 200) {
            System.out.println("Chyba coś nie tak, więc przerywam.");
            return;
        }
        
        String nazwaPliku = "wynik2." + Ustawienia.rozszerzenieDlaTypu(response.getMediaType());
        try(InputStream strumienDanych = response.readEntity(InputStream.class)) {
            long ileBajtow = Files.copy(strumienDanych, Paths.get(nazwaPliku), StandardCopyOption.REPLACE_EXISTING);
            System.out.printf("Zapisano %d bajtów do pliku %s\n", ileBajtow, nazwaPliku);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Gotowe");
    }

}



