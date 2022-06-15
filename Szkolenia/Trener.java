package J29_3_Szkolenia;

public class Trener {
    String imie;
    String nazwisko;


    public Trener(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
            }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
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
        return "Trener{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
