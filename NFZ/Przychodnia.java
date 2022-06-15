package J29_4_NFZ;

import java.util.ArrayList;

public class Przychodnia {
    String nazwaPrzychodni;
    String miasto;
    ArrayList<Pacjent> listaPacjentow = new ArrayList<>();

    public Przychodnia(String nazwaPrzychodni, String miasto, ArrayList<Pacjent> listaPacjentow) {
        this.nazwaPrzychodni = nazwaPrzychodni;
        this.miasto = miasto;
        this.listaPacjentow = listaPacjentow;
    }
    public Przychodnia(String nazwaPrzychodni, String miasto) {
        this.nazwaPrzychodni = nazwaPrzychodni;
        this.miasto = miasto;
    }

    public String getNazwaPrzychodni() {
        return nazwaPrzychodni;
    }

    public void setNazwaPrzychodni(String nazwaPrzychodni) {
        this.nazwaPrzychodni = nazwaPrzychodni;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public ArrayList<Pacjent> getListaPacjentow() {
        return listaPacjentow;
    }

    public void setListaPacjentow(ArrayList<Pacjent> listaPacjentow) {
        this.listaPacjentow = listaPacjentow;
    }

    @Override
    public String toString() {
        return "Przychodnia{" +
                "nazwaPrzychodni='" + nazwaPrzychodni + '\'' +
                ", miasto='" + miasto + '\'' +
                ", listaPacjentow=" + listaPacjentow +
                '}';
    }
}
