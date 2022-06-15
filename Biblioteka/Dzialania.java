package J50RBiblioteka;

import java.io.FileNotFoundException;

public interface Dzialania {
    public void wypozyczanie(String tytulKsiazki, String nazwisko, String imie) throws FileNotFoundException;
    public void zwrot(String nazwisko);
    public void listaKsiazekWypozyczonych(String nazwisko);
    public void listaKsiazekNiewypozyczonych();
}
