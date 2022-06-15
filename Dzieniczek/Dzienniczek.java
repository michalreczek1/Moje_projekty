package Dzieniczek;

import java.util.Scanner;

public class Dzienniczek extends UczenController {
    Scanner scanner = new Scanner(System.in);
    public String nazwaSzkoly;

    public Dzienniczek(String nazwaSzkoly) {
        this.nazwaSzkoly = nazwaSzkoly;
        this.menu();
    }

    public void menu() {
        String menu;
        while (true) {
            System.out.println("Witaj w dzienniczku szkoły " + this.nazwaSzkoly);
            System.out.println("D-dodaj ucznia, P-pokaz uczniów, O - dodaj ocenę, U-usun ucznia, M- modyfikuj, K-koniec");
            menu = scanner.nextLine().toUpperCase();
            if (menu.equals("D")) {
                System.out.println("Podaj imię ucznia: ");
                String imie = scanner.nextLine().toUpperCase();
                System.out.println("Podaj nazwisko ucznia: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                this.dodajUcznia(imie, nazwisko);

            } else if (menu.equals("P")) {
                this.pokazUczniow();

            } else if (menu.equals("O")) {
                System.out.println("Podaj nazwisko ucznia, któremu chcesz dodać ocenę: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                System.out.println("Podaj Ocenę: ");
                int ocena = scanner.nextInt();
                this.dodajOcene(nazwisko, ocena);
                this.srednia();
                scanner.nextLine();

            } else if (menu.equals("U")) {
                System.out.println("Podaj nazwisko ucznia, którego chcesz usunąć z bazy: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                this.usunUcznia(nazwisko);

            } else if (menu.equals("M")) {
                System.out.println("Podaj nazwisko ucznia, któremu chcesz zmienić dane: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                System.out.println("Podaj nowe nazwisko: ");
                String noweNazwisko = scanner.nextLine();
                System.out.println("Podaj nowe imie:  ");
                String noweImie = scanner.nextLine();
                this.zmiendane(nazwisko, noweNazwisko, noweImie);
            } else if (menu.equals("K")) {
                System.out.println("Zakończono działanie programu");
                break;
            } else {
                System.out.println("Nieprawidłowa opcja menu");
            }
        }

    }
}

