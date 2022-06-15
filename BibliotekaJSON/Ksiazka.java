package BibliotekaJSON;

public class Ksiazka {
    String autor;
    String tytul;
    String rokWydania;

    public Ksiazka(String autor, String tytul, String rokWydania) {
        this.autor = autor;
        this.tytul = tytul;
        this.rokWydania = rokWydania;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "autor='" + autor + '\'' +
                ", tytul='" + tytul + '\'' +
                ", rokWydania='" + rokWydania + '\'' +
                '}';
    }
}
