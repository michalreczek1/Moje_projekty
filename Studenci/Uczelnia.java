package J38_1Studenci;


import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Uczelnia extends StudentController {
    Scanner scanner = new Scanner(System.in);
    String nazwaUCzelni;

    public Uczelnia(String nazwaUCzelni) throws IOException {
        this.nazwaUCzelni = nazwaUCzelni;
        this.menu();
    }

    public void menu() throws IOException {
        String menu, imie, nazwisko;

        while (true) {

            System.out.println("Witaj w uczelni " + this.nazwaUCzelni);
            System.out.println("D-dodaj studenta, U-usuń studenta, O-dodaj ocenę studentowi, L-lista studentów P-pokaż oceny studenta, K-koniec");
            menu = scanner.nextLine().toUpperCase();

            if (menu.equals("D")) {
                try {
                    System.out.println("Podaj imię studenta: ");
                    imie = scanner.nextLine().toUpperCase();
                    System.out.println("Podaj nazwisko studenta: ");
                    nazwisko = scanner.nextLine().toUpperCase();
                    dodajStudenta(imie, nazwisko);
                } catch (InputMismatchException a) {
                    System.out.println("Podajemy litery bez liczb.");
                }
            } else if (menu.equals("U")) {
                System.out.println("Podaj nazwisko studenta, którego chcesz usunąć: ");
                nazwisko = scanner.nextLine().toUpperCase();
                usunStudenta(nazwisko);
            } else if (menu.equals("O")) {
                System.out.println("Podaj nazwisko studenta, któremu chcesz dodać ocenę: ");
                nazwisko = scanner.nextLine().toUpperCase();
                dodajOcene(nazwisko);
            } else if (menu.equals("P")) {
                System.out.println("Podaj nazwisko studenta, którego oceny chcesz wyświetlić: ");
                nazwisko = scanner.nextLine().toUpperCase();
                pokazOcenyStudenta(nazwisko);
            } else if (menu.equals("L")) {
                pokazlisteStudentow();
            }
            else if (menu.equals("K")) {
                System.out.println("Zakończono działanie prograu");

                FileWriter plik = new FileWriter("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J38_1Studenci\\oceny.txt", false);
                for (Student x : listaStudentow) {
                    plik.append(x.imie + "," + x.nazwisko + ";");
                    for (int i = 0; i < x.listaOcen.size(); i++) {
                        plik.append(x.listaOcen.get(i) + ",");
                    }
                    plik.append("\n");
                }
                plik.close();
                break;
            }
        }
    }
}
