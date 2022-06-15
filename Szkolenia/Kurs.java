package J29_3_Szkolenia;

import java.util.ArrayList;

public class Kurs {
    String nazwaKursu;
    ArrayList<Trener> ListaTrenerow = new ArrayList<>();
    String termin;
    ArrayList<Kursant> ListaKursantow = new ArrayList<>();
    String miejsce;

    public Kurs(String nazwaKursu, ArrayList<Trener> listaTrenerow, String termin, ArrayList<Kursant> listaKursantow, String miejsce) {
        this.nazwaKursu = nazwaKursu;
        ListaTrenerow = listaTrenerow;
        this.termin = termin;
        ListaKursantow = listaKursantow;
        this.miejsce = miejsce;
    }
    public Kurs(String nazwaKursu, ArrayList<Trener> listaTrenerow) {
        this.nazwaKursu = nazwaKursu;
        ListaTrenerow = listaTrenerow;
        this.termin = termin;
    }
    public Kurs(String nazwaKursu,  String termin, String miejsce) {
        this.nazwaKursu = nazwaKursu;
        this.termin = termin;
        this.miejsce = miejsce;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public ArrayList<Trener> getListaTrenerow() {
        return ListaTrenerow;
    }

    public void setListaTrenerow(ArrayList<Trener> listaTrenerow) {
        ListaTrenerow = listaTrenerow;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public ArrayList<Kursant> getListaKursantow() {
        return ListaKursantow;
    }

    public void setListaKursantow(ArrayList<Kursant> listaKursantow) {
        ListaKursantow = listaKursantow;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "nazwaKursu='" + nazwaKursu + '\'' +
                ", ListaTrenerow=" + ListaTrenerow +
                ", termin='" + termin + '\'' +
                ", ListaKursantow=" + ListaKursantow +
                ", miejsce='" + miejsce + '\'' +
                '}';
    }
}