package BibliotekaJSON;

import java.util.ArrayList;

public class Osoba {

    public String imie;
    public String nazwisko;
    public ArrayList <Ksiazka> listaWypozyczonychKsiazek = new ArrayList<>();

    public Osoba(String imie, String nazwisko, ArrayList<Ksiazka> listaWypozyczonychKsiazek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.listaWypozyczonychKsiazek = listaWypozyczonychKsiazek;
    }
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", listaWypozyczonychKsiazek=" + listaWypozyczonychKsiazek +
                '}';
    }
}
