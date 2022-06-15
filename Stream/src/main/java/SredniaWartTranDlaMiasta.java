package src.main.java;

import javax.swing.*;
import java.util.List;
import java.util.OptionalDouble;

public class SredniaWartTranDlaMiasta {
    public static void main(String[] args) {
        List<Transakcja> transakcja = ObslugaCSV.wczytaj("sprzedaz.csv");
        String miasto = JOptionPane.showInputDialog("Podaj nazwę miasta, np. Kraków:");

        for(Transakcja x:transakcja) {
            double wartosc = x.getWartosc(x.getCena(),x.getSztuk());
            x.setWartosc(wartosc);
        }
        OptionalDouble avg = transakcja.stream()
                .filter(tran -> tran.getMiasto().equals(miasto))
                .mapToDouble(Transakcja::getWartosc)
                .average();

        if (avg.isPresent()) {
            System.out.printf("średnia wartośc transakcji dla %s to %8.2f zł", miasto, avg.getAsDouble());
        } else {
            System.out.println("Nie ma transakcj dla wybranego miasta.");
        }




    }
}
