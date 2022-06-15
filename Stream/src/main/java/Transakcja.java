package src.main.java;

import java.time.LocalDate;
import java.util.Objects;

public class Transakcja {
    private int id;
    private LocalDate data;
    private String miasto;
    private String sklep;
    private String kategoria;
    private String towar;
    private double cena;
    private int sztuk;

    public double getWartosc() {
        return wartosc;
    }

    private double wartosc;

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public Transakcja(int id, LocalDate data, String miasto, String sklep, String kategoria, String towar, double cena, int sztuk, double wartosc) {
        this.id = id;
        this.data = data;
        this.miasto = miasto;
        this.sklep = sklep;
        this.kategoria = kategoria;
        this.towar = towar;
        this.cena = cena;
        this.sztuk = sztuk;
        this.wartosc = wartosc;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getSklep() {
        return sklep;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getTowar() {
        return towar;
    }

    public double getCena() {
        return cena;
    }

    public int getSztuk() {
        return sztuk;
    }

    @Override
    public String toString() {
        return "Transakcja{" +
                "id=" + id +
                ", data=" + data +
                ", miasto='" + miasto + '\'' +
                ", sklep='" + sklep + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", towar='" + towar + '\'' +
                ", cena=" + cena +
                ", sztuk=" + sztuk +
                ", wartosc=" + wartosc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transakcja that = (Transakcja) o;
        return id == that.id && Double.compare(that.cena, cena) == 0 && sztuk == that.sztuk && Double.compare(that.wartosc, wartosc) == 0 && Objects.equals(data, that.data) && Objects.equals(miasto, that.miasto) && Objects.equals(sklep, that.sklep) && Objects.equals(kategoria, that.kategoria) && Objects.equals(towar, that.towar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, miasto, sklep, kategoria, towar, cena, sztuk, wartosc);
    }

    public static double getWartosc (double cena, int sztuk) {

        double wartosc = sztuk * cena;

        return wartosc;
    }

}
