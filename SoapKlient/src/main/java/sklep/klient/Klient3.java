package sklep.klient;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import sklep.generated.*;

public class Klient3 {

    public static void main(String[] args) {
        SklepService service = new SklepService();
        Sklep sklep = service.getSklepPort();
        
        while(true) {
            String odp = JOptionPane.showInputDialog("Podaj id produktu");
            if(odp == null) break;
            int id = Integer.parseInt(odp);
            
            try {
                Product produkt = sklep.odczytajWedlugId(id);
                JOptionPane.showMessageDialog(null,
                        produkt.getProductName() + " " + produkt.getPrice() + "\n" + produkt.getDescription());
                
                byte[] zdjecie = sklep.foto(id);
                JOptionPane.showMessageDialog(null, new ImageIcon(zdjecie));
                
            } catch (RecordNotFound_Exception e) {
                System.out.println(e.getMessage());
            } catch (DBException_Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}



