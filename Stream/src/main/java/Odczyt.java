package src.main.java;

import java.util.List;

public class Odczyt {
    public static void main(String[] args) {
        List<Transakcja> transakcja = ObslugaCSV.wczytaj("sprzedaz.csv");
        System.out.println("Odczytano" + transakcja.size() + "rekordów: ");
        for (Transakcja x: transakcja) {
            System.out.println(x);
        }

    }
}
