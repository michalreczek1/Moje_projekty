package J29_1Firma;

import java.util.Scanner;

public class Firma  extends PracownikController{
    Scanner scanner = new Scanner(System.in);
    public String nazwaFirmy;

    public Firma(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
        this.menu();
    }
    public void menu(){

        String menu;

        while(true) {

            System.out.println("Witaj w fimie " + this.nazwaFirmy);
            System.out.println("D-dodaj pracownika, P-pokaz pracownikow, U-usun pracownika, Z-zmien kontrakt, K-koniec");
            menu = scanner.nextLine().toUpperCase();

            if (menu.equals("D")) {
                System.out.println("Podaj imię pracownika: ");
                String imie = scanner.nextLine().toUpperCase();
                System.out.println("Podaj nazwisko pracownika: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                System.out.println("Podaj rodzaj kontraktu pracownika (S/E): ");
                String kontrakt = scanner.nextLine().toUpperCase();
                if (kontrakt.equals("S")) {
                    this.dodajPracownika(imie, nazwisko);
                }
                else if (kontrakt.equals("E")) {
                    System.out.println("Podaj pensję pracownika: ");
                    int pensja = scanner.nextInt();
                    scanner.nextLine();
                    this.dodajPracownika(imie, nazwisko, kontrakt, pensja);
                }
                //pytania: imie, nazwisko, kontrakt (S, E) pensja
                //staz - 1000 (domyslnie)
            } else if (menu.equals("P")) {
                this.pokazPracownikow();
                //Imię: .... Nazwisko: .... Kontrakt: ... Pensja: ...
            } else if (menu.equals("U")) {
                System.out.println("Podaj nazwisko pracownika, ktorego chcesz usunąć z bazy: ");
                String nazwisko = scanner.nextLine().toUpperCase();
                this.usunPracownika(nazwisko);
                //nazwisko
            } else if (menu.equals("Z")) {
                System.out.println("Podaj nazwisko pracownika, któremu chcesz zmienić:");
                String nazwisko = scanner.nextLine().toUpperCase();
                System.out.println("Podaj wysokość pensji: ");
                int pensja = scanner.nextInt();
                this.zmienKontrakt(nazwisko, pensja);
                scanner.nextLine();
                //nazwisko
                //pensja
                //staz -> etat, etat -> etat AUTOMAT
            } else if (menu.equals("K")) {
                System.out.println("Zakończono działanie programu");
                break;
            }
        }
    }
}
