package J38_1Studenci;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    static ArrayList<Student> listaStudentow = new ArrayList<>();

    public void dodajStudenta (String imie, String nazwisko) {
        Student student = new Student(imie, nazwisko);
        listaStudentow.add(student);
        System.out.println("Pomyślnie dodano studenta.");
    }

    public void usunStudenta (String nazwisko) {
        for (Student x: listaStudentow) {
            if (x.nazwisko.equals(nazwisko)) {
                listaStudentow.remove(x);
                System.out.println("Pomyślnie usunięto studenta z listy.");
            } else {
                System.out.println("Nie znaleziono studenta. Błędne dane.");
            }
        }

    }

    public void dodajOcene (String nazwisko) {
        Scanner scanner = new Scanner(System.in);
        String ocena;
        for (Student x: listaStudentow) {
            if (x.nazwisko.equals(nazwisko)) {
                System.out.println("znaleziono studenta: " + x.imie + " " + x.nazwisko);
                System.out.println("Podaj ocenę (6-1): ");
                ocena = scanner.nextLine().trim();
                x.listaOcen.add(ocena);
                System.out.println("Pomyślnie dodano ocenę.");
            } else {
                System.out.println("Nie znaleziono studenta. Błędne dane.");
            }
        }

    }

    public void pokazOcenyStudenta (String nazwisko) {
        for (Student x: listaStudentow) {
            if (x.nazwisko.equals(nazwisko)) {
                System.out.println("Oto oceny studenta: " + x.imie + " " + x.nazwisko + " " + x.listaOcen);
            }
        }
    }

    public void pokazlisteStudentow () {
        for (Student x: listaStudentow) {
            System.out.println("Imię: " + x.imie + " Nazwisko: " + x.nazwisko + " Oceny: " + x.listaOcen);
        }
    }

}
