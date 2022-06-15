package src.main.java;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Z3StatystykiDlaWszystkich {
    public static void main(String[] args) {
        List<Transakcja> transakcja = ObslugaCSV.wczytaj("sprzedaz.csv");

        for(Transakcja x:transakcja) {
            double wartosc = x.getWartosc(x.getCena(),x.getSztuk());
            x.setWartosc(wartosc);
        }

        Map<String, DoubleSummaryStatistics> stats = transakcja.stream()
                .collect(Collectors.groupingBy(Transakcja::getMiasto,
                        Collectors.summarizingDouble(Transakcja::getWartosc)));

        System.out.println("| Miasto  |    suma transakcji |");

        stats.forEach((miasto, stat) -> {
            System.out.printf("%-10s| %16.10s zł|\n", miasto, stat.getSum());
        });
    }
}
