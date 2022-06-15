package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaCSV {

    public static List<Transakcja> wczytaj (String sciezka) {
        List<Transakcja> lista = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(sciezka))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] t = line.split(";", 10);
                Transakcja transakcja = new Transakcja(Integer.parseInt(t[0]),LocalDate.parse(t[1]),t[2],t[3],t[4],t[5],
                        Double.parseDouble(t[6]),Integer.parseInt(t[7]),0);
                lista.add(transakcja);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
