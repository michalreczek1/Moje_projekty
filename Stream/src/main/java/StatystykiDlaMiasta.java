package src.main.java;

import javax.swing.*;
import java.util.List;
import java.util.OptionalDouble;

public class StatystykiDlaMiasta {
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

        int liczbatransakcji = 0;
        for (Transakcja tran : transakcja) {
            if (tran.getMiasto().equals(miasto)) {
                liczbatransakcji++;
            }
        }
        OptionalDouble suma = OptionalDouble.of(transakcja.stream()
                .filter(tran -> tran.getMiasto().equals(miasto))
                .mapToDouble(Transakcja::getWartosc)
                .sum());

        OptionalDouble min = transakcja.stream()
                .filter(tran -> tran.getMiasto().equals(miasto))
                .mapToDouble(Transakcja::getWartosc)
                .min();

        OptionalDouble max = transakcja.stream()
                .filter(tran -> tran.getMiasto().equals(miasto))
                .mapToDouble(Transakcja::getWartosc)
                .max();


        if (avg.isPresent() && min.isPresent() && max.isPresent()) {
            System.out.printf("Statystyki dla %s:\n", miasto);
            System.out.printf("średnia wartość transakcji to %1.2f zł\n", avg.getAsDouble());
            System.out.printf("Liczba transakcji to %s.\n",liczbatransakcji);
            System.out.printf("Suma transakcji to %1.2f zł.\n",suma.getAsDouble());
            System.out.printf("Minimalna wartość transakcji to %s zł.\n",min.getAsDouble());
            System.out.printf("Maksymalna wartość transakcji to %s zł.\n",max.getAsDouble());
        } else {
            System.out.println("Nie ma transakcji dla wybranego miasta.");
        }
    }
}
