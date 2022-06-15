package Dzieniczek;

import java.util.ArrayList;

public class UczenController {
    ArrayList<Uczen> ListaUczniow = new ArrayList<>();


    public void dodajUcznia(String imie, String nazwisko) {
        Uczen uczen = new Uczen(imie, nazwisko);
        this.ListaUczniow.add(uczen);
        System.out.println("Uczeń został prawidłowo dodany do listy uczniów.");
    }

    public void pokazUczniow() {
        for (Uczen x : ListaUczniow) {
            System.out.println(x);
        }
    }

    public void dodajOcene(String nazwisko, int ocena) {
        boolean znal = false;
        for (Uczen x : ListaUczniow) {
            if (x.getNazwisko().equals(nazwisko)) {
                znal = true;
                x.oceny.add(ocena); // tu mam problem z dodaniem do listy prywatnej oceny jeśli lista jest prywatna
                System.out.println("Pomyślnie dodano ocenę.");
                break;
            }
        }
        if (znal == false) {
            System.out.println("Uczeń o podanym nazwisku nie istnieje.");
        }
    }

    public void usunUcznia(String nazwisko) {
        boolean znal = false;
        for (Uczen x : ListaUczniow) {
            if (x.getNazwisko().equals(nazwisko)) {
               znal = true;
                this.ListaUczniow.remove(x);
                System.out.println("Pomyślnie usunięto ucznia z bazy");
                break;

            }
        }
        if (znal == false) {
            System.out.println("Uczeń o podanym nazwisku nie istnieje.");
        }
    }

    public void zmiendane(String nazwisko, String noweNazwisko, String noweImie) {
        boolean znal = false;
        for (Uczen x : ListaUczniow) {
            if (x.getNazwisko().equals(nazwisko)) {
                znal = true;
                x.setImie(noweImie);
                x.setNazwisko(noweNazwisko);
                System.out.println("Pomyślnie zmieniono dane.");
                break;
            }
        }
        if (znal == false) {
            System.out.println("Uczeń o podanym nazwisku nie istnieje.");
        }
    }
    public void srednia() {
        int suma =0;
        double srednia = 0;
        for (Uczen x : ListaUczniow) {
          ArrayList<Integer> lista = x.getOceny();
          suma = 0;
          if (lista.size()>0) {
              for (int i = 0; i < lista.size(); i++) {
                  suma += lista.get(i);
              }
              srednia = suma / lista.size();
              x.setSrednia(srednia);
          }
        }
    }
}









