package J29_4_NFZ;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu, nazwaPrzychodni, miasto, imiePacjenta, nazwiskoPacjenta, nazwaChoroby;
        int minimenu;
        ArrayList<Przychodnia> listaPrzychodni = new ArrayList<>();

        while (true) {
            System.out.println("Witaj w systemie NFZ. \nWybierz właściwą opcję menu:");
            System.out.println("P-przychodnia, C-pacjent K-koniec");
            menu = scanner.nextLine().toUpperCase();
            if (menu.equals("P")) {
                System.out.println("Menu: 1-dodaj przychodnię, 2-dodaj pacjenta, " +
                        "3-lista przychodni, 4-lista pacjentow w przychodni, 5-powrót do menu głównego");
                minimenu = scanner.nextInt();
                scanner.nextLine();
                if (minimenu == 1) {
                    System.out.println("Podaj nazwę przychodni:");
                    nazwaPrzychodni = scanner.nextLine().toUpperCase();
                    System.out.println("Podaj nazwę miasta, w którym znajduje się przychodnia:");
                    miasto = scanner.nextLine().toUpperCase();
                    Przychodnia przychodnia = new Przychodnia(nazwaPrzychodni, miasto);
                    listaPrzychodni.add(przychodnia);
                    System.out.println("Pomyślnie dodano przychodnię");
                } else if (minimenu == 2) {
                    System.out.println("Podaj imię pacjenta:");
                    imiePacjenta = scanner.nextLine().toUpperCase();
                    System.out.println("Podaj nazwisko pacjenta: ");
                    nazwiskoPacjenta = scanner.nextLine().toUpperCase();
                    Pacjent pacjent = new Pacjent(imiePacjenta, nazwiskoPacjenta);
                    System.out.println("Podaj nazwę przychodni, do której chcesz dodać pacjenta:");
                    nazwaPrzychodni = scanner.nextLine().toUpperCase();
                    for (Przychodnia y : listaPrzychodni) {
                        if (nazwaPrzychodni.equals(y.nazwaPrzychodni)) {
                            System.out.println("Znaleziono przychodnię.");
                            y.listaPacjentow.add(pacjent);
                            System.out.println("Dodano pacjenta.");
                        }
                    }
                } else if (minimenu == 3) {
                    System.out.println("Oto lista przychodni:");
                    for (Przychodnia x: listaPrzychodni) {
                        System.out.println("Nazwa przychodni: " + x.nazwaPrzychodni + " " + "Miasto: " + x.miasto + "\n"
                        + "Lista pacjentow: " +x.listaPacjentow + "\n");
                    }

                } else if (minimenu == 4) {
                    System.out.println("Podaj nazwę przychodni, której pacjentów chcesz wyświetlić:");
                    nazwaPrzychodni = scanner.nextLine().toUpperCase();
                    for (Przychodnia y : listaPrzychodni) {
                        if (nazwaPrzychodni.equals(y.nazwaPrzychodni)) {
                                System.out.println(y.listaPacjentow);
                        }
                    }
                } else if (minimenu == 5) {
                    System.out.println("Menu główne: ");
                }
            } else if (menu.equals("C")) {
                System.out.println("Menu: 1-dodaj chorobę, 2-lista chorób pacjenta, 3-powrót do menu głównego");
                minimenu = scanner.nextInt();
                scanner.nextLine();
                if (minimenu == 1) {
                    System.out.println("Podaj nazwisko pacjenta, któremu chcesz przypisać rozpoznaną chorobę:");
                    nazwiskoPacjenta = scanner.nextLine().toUpperCase();
                    for (Przychodnia x : listaPrzychodni) {
                        for (Pacjent d : x.listaPacjentow) {
                            if (nazwiskoPacjenta.equals(d.nazwisko)) {
                                System.out.println("Znaleziono pacjenta.");
                                System.out.println("Podaj nazwę choroby, którą chcesz dopisać:");
                                nazwaChoroby = scanner.nextLine().toUpperCase();
                                d.choroby.add(nazwaChoroby);
                                System.out.println("Pomyślnie dodano chorobę pacjenta.");
                            }
                        }
                    }
                } else if (minimenu == 2) {
                    System.out.println("Podaj nazwisko pacjenta, którego choroby chcesz wyświetlić:");
                    nazwiskoPacjenta = scanner.nextLine().toUpperCase();
                    for (Przychodnia x : listaPrzychodni) {
                        for (Pacjent d : x.listaPacjentow) {
                            if (nazwiskoPacjenta.equals(d.nazwisko)) {
                                System.out.println("Znaleziono pacjenta." + d.nazwisko + " " + d.imie + " " + "Oto lista chorób:");
                                System.out.println (d.choroby);
                            }
                        }
                    }
                }
            } else if (menu.equals("K")) {
                System.out.println("Zakończono działanie programu.");
                break;
            }
        }
    }
}
