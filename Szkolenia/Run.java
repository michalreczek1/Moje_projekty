package J29_3_Szkolenia;

import Uczelnia.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu, nazwaKursu, terminKursu, miejsceKursu, imieTrenera, nazwiskoTrenera, imieUczestnika,
                nazwiskoUczestnika, noweImie, noweNazwisko, nowaNazwa, noweMiejsce, nowyTermin;
        int minimenu;
        ArrayList<Kurs> ListaKursow = new ArrayList<>();


        while (true) {
            System.out.println("Witaj na uczelni. \nWybierz właściwą opcję menu");
            System.out.println("D-dodaj kurs, T-dodaj trenera do kursu, N-dodaj uczestnika do kursu, U-usuń trenera z kursu, X-usun uczestnika z kursu, K-usun kurs, W-wyświetl listę kursów," +
                    " C-modyfikuj dane uczestnika, M- modyfikuj dane kursu, E-koniec");
            menu = scanner.nextLine().toUpperCase();
            if (menu.equals("D")) {
                System.out.println("Podaj nazwę kursu: ");
                nazwaKursu = scanner.nextLine().toUpperCase();
                System.out.println("Podaj termin kursu: ");
                terminKursu = scanner.nextLine().toUpperCase();
                System.out.println("Podaj miejsce kursu: ");
                miejsceKursu = scanner.nextLine().toUpperCase();
                Kurs kurs = new Kurs(nazwaKursu, terminKursu, miejsceKursu);
                ListaKursow.add(kurs);
                System.out.println("Pomyślnie dodano kurs do bazy.\n");
                System.out.println(kurs + "\n");
            } else if (menu.equals("T")) {
                System.out.println("Podaj nazwę kursu ");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu)) {
                        znal = true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Podaj imie trenera: ");
                        imieTrenera = scanner.nextLine().toUpperCase();
                        System.out.println("Podaj nazwisko trenera: ");
                        nazwiskoTrenera = scanner.nextLine().toUpperCase();
                        Trener trener = new Trener(imieTrenera, nazwiskoTrenera);
                        x.ListaTrenerow.add(trener);
                        System.out.println("Pomyślnie dodano trenera.");
                        System.out.println(ListaKursow);
                        break;
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwieu nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("N")) {
                System.out.println("Dostępne kursy to: " + ListaKursow + "\n");
                System.out.println("Podaj nazwę kursu: ");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu) && x.ListaKursantow.size() < 15) {
                        znal = true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Podaj imie uczestnika: ");
                        imieUczestnika = scanner.nextLine().toUpperCase();
                        System.out.println("Podaj nazwisko uczestnika: ");
                        nazwiskoUczestnika = scanner.nextLine().toUpperCase();
                        Kursant kursant = new Kursant(imieUczestnika, nazwiskoUczestnika);
                        x.ListaKursantow.add(kursant);
                        System.out.println("Pomyślnie dodano uczestnika.");
                        System.out.println(ListaKursow);
                        break;
                    } else if (x.ListaKursantow.size() >= 14) {
                        System.out.println("Osiągnięto maksymalną liczbę uczerstników na kursie (15)");
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwieu nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("U")) {
                System.out.println("Podaj nazwę kursu:");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu)) {
                        znal = true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Podaj nazwisko trenera:");
                        nazwiskoTrenera = scanner.nextLine().toUpperCase();
                        for (Trener y : x.ListaTrenerow) {
                            if (y.nazwisko.equals(nazwiskoTrenera)) {
                                x.ListaTrenerow.remove(y);
                                System.out.println("Pomyślnie usunięto trenera.");
                                break;
                            }
                        }
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwieu nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("X")) {
                System.out.println("Podaj nazwę kursu:");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu)) {
                        znal = true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Podaj nazwisko uczestnika, którego chcesz usunąć:");
                        nazwiskoUczestnika = scanner.nextLine().toUpperCase();
                        for (Kursant z : x.ListaKursantow) {
                            if (z.nazwisko.equals(nazwiskoUczestnika)) {
                                x.ListaKursantow.remove(z);
                                System.out.println("Pomyślnie usunięto uczestnika.");
                                break;
                            }
                        }
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwieu nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("K")) {
                System.out.println("Podaj nazwę kursu:");
                nazwaKursu = scanner.nextLine().toUpperCase();
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu) && x.ListaKursantow.size() == 0) {
                        ListaKursow.remove(x);
                    } else if (x.ListaKursantow.size() > 0) {
                        System.out.println("Nie można uzunąć kursu, na który zapisani są kursanci.");
                    }
                }
            } else if (menu.equals("W")) {
                for (Kurs x : ListaKursow) {
                    System.out.println("Nazwa kursu: " + x.getNazwaKursu() + "\n" + "Trenerzy: " + x.ListaTrenerow + "\n" +
                            "Uczestnicy: " + x.ListaKursantow);
                }
            } else if (menu.equals("C")) {
                System.out.println("Podaj nazwę kursu:");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu)) {
                        znal =true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Podaj nazwisko uczestnika, którego dane chcesz zmodyfikować: ");
                        nazwiskoUczestnika = scanner.nextLine().toUpperCase();
                        for (Kursant z : x.ListaKursantow) {
                            if (z.nazwisko.equals(nazwiskoUczestnika)) {
                                System.out.println("Znaleziono uczestnika.");
                                System.out.println("Podaj nowe nazwisko: ");
                                noweNazwisko = scanner.nextLine();
                                System.out.println("Podaj nowe imie: ");
                                noweImie = scanner.nextLine().toUpperCase();
                                z.setNazwisko(noweNazwisko);
                                z.setImie(noweImie);
                                System.out.println("Pomyślnie zmieniono dane uczestnika.");
                                break;
                            }
                        }
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwieu nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("M")) {
                System.out.println("Podaj nazwę kursu:");
                nazwaKursu = scanner.nextLine().toUpperCase();
                boolean znal = false;
                for (Kurs x : ListaKursow) {
                    if (x.getNazwaKursu().equals(nazwaKursu)) {
                        znal =true;
                        System.out.println("Znaleziono kurs.\n");
                        System.out.println("Jakie dane chcesz zmienić? (1-zmiana nazwy, 2-zmiana danych trenera, 3-zmiana terminu, 4-zmiana miejsca)");
                        minimenu = scanner.nextInt();
                        scanner.nextLine();
                        if (minimenu == 1) {
                            System.out.println("Podaj nową nazwę szkolenia: ");
                            nowaNazwa = scanner.nextLine().toUpperCase();
                            x.setNazwaKursu(nowaNazwa);
                        } else if (minimenu == 2) {
                            System.out.println("Podaj nazwisko trenera, którego dane chcesz zmienić: ");
                            nazwiskoTrenera = scanner.nextLine().toUpperCase();
                            for (Trener z : x.ListaTrenerow) {
                                if (z.nazwisko.equals(nazwiskoTrenera)) {
                                    System.out.println("Znaleziono trenera.");
                                    System.out.println("Podaj nowe nazwisko: ");
                                    noweNazwisko = scanner.nextLine().toUpperCase();
                                    System.out.println("Podaj nowe imie: ");
                                    noweImie = scanner.nextLine().toUpperCase();
                                    z.setNazwisko(noweNazwisko);
                                    z.setImie(noweImie);
                                    System.out.println("Pomyślnie zmieniono dane trenera.");
                                    break;
                                }
                            }
                        }else if (minimenu == 3) {
                            System.out.println("Podaj nowy termin szkolenia: ");
                            nowyTermin = scanner.nextLine().toUpperCase();
                            x.setTermin(nowyTermin);
                        } else if (minimenu == 4) {
                            System.out.println("Podaj nowy termin szkolenia: ");
                            noweMiejsce= scanner.nextLine().toUpperCase();
                            x.setMiejsce(noweMiejsce);
                        } else {
                            System.out.println("Nieprawidłowa opcja menu.");
                        }
                    }
                }
                if (znal == false) {
                    System.out.println("Kurs o podanej nazwie nie istnieje. \nSpróbuj jeszcze raz.\n");
                }
            } else if (menu.equals("E")) {
                System.out.println("To już jest koniec nie ma już nic...");
                break;
            } else {
                System.out.println("Nieprawidłowa opcja menu");
            }
        }
    }
}