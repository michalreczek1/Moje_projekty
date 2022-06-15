package J29_3_Szkolenia;

public class Kursant {
    String imie;
    String nazwisko;

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

    public Kursant(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

    }

    @Override
    public String toString() {
        return "Kursant{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
