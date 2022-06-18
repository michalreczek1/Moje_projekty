package sklep.klient;

import java.util.List;

import sklep.generated.DBException_Exception;
import sklep.generated.Product;
import sklep.generated.Sklep;
import sklep.generated.SklepService;

public class WypiszWszystkie {

    public static void main(String[] args) {
        SklepService service = new SklepService();
        Sklep sklep = service.getSklepPort();
        
        try {
            List<Product> produkty = sklep.odczytajWszystkieProdukty();
            for (Product product : produkty) {
                System.out.println(product.getProductName() + " za " + product.getPrice());
            }
        } catch (DBException_Exception e) {
            e.printStackTrace();
        }

    }

}



