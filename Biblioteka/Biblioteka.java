package J50RBiblioteka;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka implements Dzialania {

    static ArrayList<Ksiazka> listaKsiazek = new ArrayList<>();
    static ArrayList<Ksiazka> listaWypozyczonych = new ArrayList<>();
    static public ArrayList<Osoba> listaOsob = new ArrayList<>();
    public String nazwaBiblioteki;

    public Biblioteka(String nazwaBiblioteki) throws IOException {
        this.nazwaBiblioteki = nazwaBiblioteki;
        this.menu();
    }

    public void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String menu, imie, nazwisko, tytul;

        while (true) {
            System.out.println("Witaj w Bibliotece " + this.nazwaBiblioteki);
            System.out.println("D-dodaj czytelnika, U-usuń czytelnika; W-wypożycz książkę, Z-Zwróć książkę, " +
                    "L-Lista książek wypożyczonych przez czytelnika, N-lista książek dostępnych do wypożyczenia, C-lista czytelników, K-koniec");
            menu = scanner.nextLine().toUpperCase();
            if (menu.equals("W")) {
                System.out.println("Podaj imię czytelnika, która chce wypożyczyć książkę: ");
                imie = scanner.nextLine().toUpperCase();
                System.out.println("Podaj nazwisko czytelnika, która chce wypożyczyć książkę: ");
                nazwisko = scanner.nextLine().toUpperCase();
                System.out.println("Oto lista książek, którą możesz wypożyczyć: ");
                listaKsiazekNiewypozyczonych();
                System.out.println("Podaj tytuł, lub fragment tytułu książki, którą chcesz wypożyczyć:");
                tytul = scanner.nextLine().toUpperCase();
                wypozyczanie(tytul, nazwisko, imie);
            } else if (menu.equals("D")) {
                System.out.println("Podaj imię nowego czytelnika:");
                imie = scanner.nextLine().toUpperCase().trim();
                System.out.println("Podaj nazwisko nowego czytelnika:");
                nazwisko = scanner.nextLine().toUpperCase().trim();
                Osoba osoba = new Osoba(imie, nazwisko);
                listaOsob.add(osoba);
            } else if (menu.equals("U")) {
                System.out.println("Podaj imię czytelnika: ");
                imie = scanner.nextLine().toUpperCase();
                System.out.println("Podaj nazwisko czytelnika:");
                nazwisko = scanner.nextLine().toUpperCase();
                usun(imie, nazwisko);
            } else if (menu.equals("L")) {
                System.out.println("Nazwisko czytelnika, którego listę książek wypożyczonych chcesz zobaczyć:");
                nazwisko = scanner.nextLine().toUpperCase();
                listaKsiazekWypozyczonych(nazwisko);
            } else if (menu.equals("N")) {
                listaKsiazekNiewypozyczonych();
            } else if (menu.equals("Z")) {
                System.out.println("Podaj nazwisko czytelnika, który zwraca książki:");
                nazwisko = scanner.nextLine().toUpperCase();
                zwrot(nazwisko);
            } else if (menu.equals("C")) {
                listaCzytelnikow();
            } else if (menu.equals("K")) {
                System.out.println("Dziękujemy za skorzystanie z biblioteki. Zapraszamy ponownie.");



                PrintWriter plik = new PrintWriter("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J50RBiblioteka\\ksiazki.txt");
                for (Ksiazka x : listaKsiazek) {
                    plik.append(x.autor + ";" + x.tytul + ";" + x.rokWydania + "\n");
                }
                plik.close();

                FileWriter plik2 = new FileWriter("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\J50RBiblioteka\\wypozyczone.txt", false);
                for (Osoba x : listaOsob) {
                    plik2.append(x.imie + "," + x.nazwisko + ";");
                    for (Ksiazka z : x.listaWypozyczonychKsiazek) {
                        plik2.append(z.autor + "," + z.tytul + "," + z.rokWydania + ";");
                    }
                    plik2.append("\n");
                }
                plik2.close();
                break;
            } else {
                System.out.println("Nieprawidłowa opcja menu.");
            }
        }
    }

    public void usun(String imie, String nazwisko) {
            for (Osoba x : listaOsob) {
                if (x.imie.equals(imie) && x.nazwisko.equals(nazwisko)) {
                    listaOsob.remove(x);
                    System.out.println("Pomyślnie usunięto czytelnika");
                } else {
                    System.out.println("Nie znaleziono czytelnika o podanych danych.");
                    break;
                }
            }
    }


    private void listaCzytelnikow() {
        for (Osoba x : listaOsob) {
            System.out.println("Imie: " + x.imie + " Nazwisko: " + x.nazwisko);
        }
    }

    @Override
    public void wypozyczanie(String tytulKsiazki, String nazwisko, String imie) {
        Scanner scanner = new Scanner(System.in);
        String menu;
        boolean znklienta = false;
        boolean znksiazke = false;
        for (Osoba x : listaOsob) {
            if (x.nazwisko.equals(nazwisko) && imie.equals(imie)) {
                System.out.println("Znaleziono czytlnika:" + x.imie + " " + x.nazwisko);
                znklienta = true;
                for (Ksiazka z : listaKsiazek) {
                    if (z.tytul.contains(tytulKsiazki)) {
                        znksiazke = true;
                        System.out.println("Znaleziono książkę: " + z.tytul + " " + z.autor + " " + z.rokWydania);
                        System.out.println("Czy chesz wypożyczyć? (T/N)");
                        menu = scanner.nextLine().toUpperCase();
                        if (menu.equals("T")) {
                            listaKsiazek.remove(z);
                            x.listaWypozyczonychKsiazek.add(z);
                            System.out.println("Książka została wypożyczona.");
                            break;
                        } else if (menu.equals("N")) {
                            break;
                        }
                    }
                }
            }
        }
        if (!znklienta) {
            System.out.println("Nie znaleziono czytelnika. Spróbuj ponownie.");
        }
        if (!znksiazke) {
            System.out.println("Nie znaleziono książki w katalogu. Spróbuj ponownie.");
        }
    }

    @Override
    public void zwrot(String nazwisko) {
        Scanner scanner = new Scanner(System.in);
        String menu, tytul;
        boolean znklienta = false;
        boolean znksiazke = false;
        for (Osoba x : listaOsob) {
            if (x.nazwisko.equals(nazwisko)) {
                System.out.println("Znaleziono czytelnika." + x.imie + " " + x.nazwisko);
                znklienta = true;
                System.out.println("Podaj tytuł książki, którą chcesz zwrócić: ");
                tytul = scanner.nextLine().toUpperCase();
                for (Ksiazka z : x.listaWypozyczonychKsiazek) {
                    if (z.tytul.contains(tytul)) {
                        znksiazke = true;
                        System.out.println("Znaleziono książkę: " + z.tytul + " " + z.autor + " " + z.rokWydania);
                        System.out.println("Czy chesz zwrócić? (T/N)");
                        menu = scanner.nextLine().toUpperCase();
                        if (menu.equals("T")) {
                            listaKsiazek.add(z);
                            listaWypozyczonych.remove(z);
                            x.listaWypozyczonychKsiazek.remove(z);
                            System.out.println("Książka została zwrócona.");
                            break;
                        } else if (menu.equals("N")) {
                            break;
                        }
                    }
                }
                if (!znksiazke) {
                    System.out.println("Nie znaleziono książki w katalogu. Spróbuj ponownie.");
                }
            }
        }
        if (!znklienta) {
            System.out.println("Nie znaleziono czytelnika. Spróbuj ponownie.");
        }
    }

    @Override
    public void listaKsiazekWypozyczonych(String nazwisko) {
        Scanner scanner = new Scanner(System.in);
        int i=0;
        String imie;
        for (Osoba x : listaOsob) {
            if (x.nazwisko.equals(nazwisko)) {
                i++;
            }
        }
        if (i==1) {
            for (Osoba x : listaOsob) {
                if (x.nazwisko.equals(nazwisko)) {
                    System.out.println("Znaleziono czytelnika:" + x.imie + " " + x.nazwisko);
                    System.out.println("Oto lista wypożyczonych książek:");
                    int a=1;
                    for (Ksiazka z : x.listaWypozyczonychKsiazek) {
                        System.out.println((a++) + ". "+"Autor: " + z.autor + " Tytuł: " + z.tytul + " Rok wydania: " + z.rokWydania);
                    }
                    if (x.listaWypozyczonychKsiazek.size() == 0) {
                        System.out.println("Nie wypożyczono żądnej książki.\n");
                    }
                }
            }
        }
        if (i>1) {
                System.out.println("Znaleziono więcej niż jednego czytelnika o podanym nazwisku. Podaj imię:");
                imie = scanner.nextLine().toUpperCase();
            for (Osoba x : listaOsob) {
                if (x.nazwisko.equals(nazwisko)&& x.imie.equals(imie)) {
                    System.out.println("Znaleziono czytelnika:" + x.imie + " " + x.nazwisko);
                    System.out.println("Oto lista wypożyczonych książek:");
                    System.out.println(x.listaWypozyczonychKsiazek);
                    if (x.listaWypozyczonychKsiazek.size() == 0) {
                        System.out.println("Nie wypożyczono żądnej książki.\n");
                    }
                }
            }
        }
        if (i==0) {
            System.out.println("Nie znaleziono czytelnika. Spróbuj ponownie.");
        }
    }

    @Override
    public void listaKsiazekNiewypozyczonych() {
        for (Ksiazka x : listaKsiazek) {
            System.out.println("Tytuł: " + x.tytul + ", " + "Autor: " + x.autor + ", " + "Rok wydania: " + x.rokWydania);
        }
        if (listaKsiazek.size() == 0) {
            System.out.println("Wypożyczono wszystkie książki.");
        }
    }
}