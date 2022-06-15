package J50RBiblioteka;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class Run {
    public static void main(String[] args) throws IOException {
        String autor, tytul, dane, dane2, rokWydania, imie, nazwisko;

        File plik = new File("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J50RBiblioteka\\ksiazki.txt");
        Scanner odczyt = new Scanner(plik);

        while (odczyt.hasNextLine()) {
            dane = odczyt.nextLine().toUpperCase();
            String[] daneSplit = dane.split(";");
            tytul = daneSplit[0];
            autor = daneSplit[1];
            rokWydania = daneSplit[2];
            Ksiazka ksiazka = new Ksiazka(tytul, autor, rokWydania);
            Biblioteka.listaKsiazek.add(ksiazka);
        }
        odczyt.close();

        File plik2 = new File("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J50RBiblioteka\\wypozyczone.txt");
        Scanner odczyt2 = new Scanner(plik2);

        if (odczyt2.hasNext()) {

            while (odczyt2.hasNextLine()) {
                dane2 = odczyt2.nextLine().toUpperCase();
                String[] tablica1 = dane2.split(";");
                String[] tablica2 = tablica1[0].split(",");
                imie = tablica2[0];
                nazwisko = tablica2[1];
                Osoba osoba = new Osoba(imie, nazwisko);
                Biblioteka.listaOsob.add(osoba);

                for (int x = 1; x < tablica1.length; x++) {
                    String[] tablica4 = tablica1[x].split(",");
                    tytul = tablica4[0];
                    autor = tablica4[1];
                    rokWydania = tablica4[2];
                    Ksiazka ksiazka = new Ksiazka(tytul, autor, rokWydania);

                    for (Osoba z : Biblioteka.listaOsob) {
                        if (z.nazwisko.equals(nazwisko)) {
                            z.listaWypozyczonychKsiazek.add(ksiazka);
                        }
                    }
                }
            }
            odczyt.close();
        }

        Biblioteka biblioteka = new Biblioteka("Publicznej");
    }
}
