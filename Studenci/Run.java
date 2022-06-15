package J38_1Studenci;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static J38_1Studenci.StudentController.listaStudentow;

public class Run {
    public Run() throws IOException {
    }

    public static void main(String[] args) throws IOException {

        File plik = new File("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J38_1Studenci\\oceny.txt");
        Scanner odczyt = new Scanner(plik);
        String dane, imie, nazwisko;

        if (odczyt.hasNext()) {
            while (odczyt.hasNextLine()) {
                dane = odczyt.nextLine().toUpperCase();
                String[] tablica1 = dane.split(";");
                String[] tablica2 = tablica1[0].split(",");
                imie = tablica2[0];
                nazwisko = tablica2[1];
                Student student = new Student(imie, nazwisko);
                listaStudentow.add(student);
                String[] tablica3 = tablica1[1].split(",");
                for (Student x : listaStudentow) {
                    if (x.imie.equals(imie) && x.nazwisko.equals(nazwisko)) {
                        for (String y : tablica3) {
                            x.listaOcen.add(y);
                        }
                    }
                }
            }
        }
        odczyt.close();

        Uczelnia uczelnia = new Uczelnia("Publicznej");
    }
}

