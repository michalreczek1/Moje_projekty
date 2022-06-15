package src.main.java;

import java.util.List;
import java.util.OptionalDouble;

public class SredniaWartTransakcji {
    public static void main(String[] args) {
        List<Transakcja> transakcja = ObslugaCSV.wczytaj("sprzedaz.csv");

        for(Transakcja x:transakcja) {
            double wartosc = x.getWartosc(x.getCena(),x.getSztuk());
            x.setWartosc(wartosc);
        }
        OptionalDouble avg = transakcja.stream()
                .mapToDouble(Transakcja::getWartosc)
                .average();

        System.out.printf("średnia wartość transakcji to %8.2f",avg.getAsDouble());





    }
}
