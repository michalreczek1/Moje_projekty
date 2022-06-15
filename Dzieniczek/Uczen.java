package Dzieniczek;

import java.util.ArrayList;

public class Uczen {
    private String imie;
    private String nazwisko;
    ArrayList<Integer> oceny = new ArrayList<>();
    double srednia;

    public Uczen(String imie, String nazwisko, ArrayList<Integer> oceny, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
        this.srednia = srednia;
    }
    public Uczen(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public Uczen(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Uczen(String imie, String nazwisko, ArrayList<Integer> oceny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public ArrayList<Integer> getOceny() {
        return oceny;
    }

    public void setOceny(ArrayList<Integer> oceny) {this.oceny = oceny;}

    public double getSrednia() {
        return srednia;
    }

    public void setSrednia(double srednia) {
        this.srednia = srednia;
    }

    @Override
    public String toString() {
        return "Uczen{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", Oceny=" + oceny +
                ", srednia=" + srednia +
                '}';
    }
}