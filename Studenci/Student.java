package J38_1Studenci;

import java.util.ArrayList;

public class Student {
    String imie;
    String nazwisko;
    ArrayList <String> listaOcen = new ArrayList<String>();

    public Student(String imie, String nazwisko, ArrayList<String> listaOcen) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.listaOcen = listaOcen;
    }

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", listaOcen=" + listaOcen +
                '}';
    }
}
