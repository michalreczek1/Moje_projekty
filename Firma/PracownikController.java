package J29_1Firma;

import java.util.ArrayList;


public class PracownikController {
    ArrayList<Pracownik> ListaPracownikow = new ArrayList<>();

    public void dodajPracownika(String imie, String nazwisko) {
        Pracownik pracownik = new Pracownik(imie, nazwisko, "staz", 1000);
        this.ListaPracownikow.add(pracownik);
        System.out.println("Pracownik Został dodany");
    }

    public void dodajPracownika(String imie, String nazwisko, String kontrakt, int pensja) { 
        Pracownik pracownik = new Pracownik(imie, nazwisko, kontrakt, pensja);
        this.ListaPracownikow.add(pracownik);
        System.out.println("Pracownik Został dodany");
    }

    public void usunPracownika(String nazwisko) {
        boolean znal = false;
        for (Pracownik x : ListaPracownikow) {
            if (x.getNazwisko().equals(nazwisko)) {
                znal = true;
                this.ListaPracownikow.remove(x);
                System.out.println("Pomyślnie usunięto nazwisko");
                break;
            }
        }
        if (znal == false) {
            System.out.println("Pracownik nie istnieje.");
        }
    }

    public void pokazPracownikow() {
        for (Pracownik x : ListaPracownikow) {
            System.out.println(x);
        }
    }

    public void zmienKontrakt(String nazwisko, int pensja) {
        boolean znal = false;
        for (Pracownik x : ListaPracownikow) {
            if (x.getNazwisko().equals(nazwisko)) {
                znal = true;
                x.setKontrakt("Etat");
                x.setPensja(pensja);
                System.out.println("Pomyślnie zmieniono dane.");
                break;
            }

        }
        if (znal == false) {
            System.out.println("Pracownik nie istnieje.");
        }
    }
}
