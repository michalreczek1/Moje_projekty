package sklep.klient;

import java.util.Scanner;

import sklep.generated.*;

public class Klient2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podłączam się do serwera...");
        
        SklepService service = new SklepService();
        Sklep sklep = service.getSklepPort();
        
        while(true) {
            System.out.print("Podaj id produktu (0 aby zakończyć): ");
            int id = scanner.nextInt();
            if(id == 0) break;
            
            try {
                Product produkt = sklep.odczytajWedlugId(id);
                System.out.println("Udało się pobrać produkt:");
                System.out.println(produkt);
                System.out.println(produkt.getProductName() + " " + produkt.getPrice());
                System.out.println(produkt.getDescription());
                
            } catch (RecordNotFound_Exception e) {
                System.out.println(e.getMessage());
            } catch (DBException_Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Koniec...");
    }

}



