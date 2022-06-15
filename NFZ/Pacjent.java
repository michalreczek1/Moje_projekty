package J29_4_NFZ;

import java.util.ArrayList;

public class Pacjent {
    String imie;
    String nazwisko;
    ArrayList<String> choroby = new ArrayList<>();

    public Pacjent(String imie, String nazwisko, ArrayList<String> choroby) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.choroby = choroby;
    }
    public Pacjent(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", choroby=" + choroby +
                '}';
    }
}
