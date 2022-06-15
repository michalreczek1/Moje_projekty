package BibliotekaJSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;



public class Run {
    public static void main(String[] args) throws IOException {

        Gson json = new Gson();

        File plik = new File("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\BibliotekaJSON\\ksiazki.txt");
        Scanner odczyt = new Scanner(plik);

        String odp = odczyt.nextLine();
        Type userListType = new TypeToken<ArrayList<Ksiazka>>() {}.getType();
        Biblioteka.listaKsiazek = json.fromJson(odp,userListType);


        File plik2 = new File("C:\\Users\\micha\\IdeaProjects\\Kurs_java_ALX\\src\\BibliotekaJSON\\wypozyczone.txt");
        Scanner odczyt2 = new Scanner(plik2);

        if (odczyt2.hasNext()) {
            String odp2 = odczyt2.nextLine();
            Type userListType2 = new TypeToken<ArrayList<Osoba>>() {
            }.getType();
            Biblioteka.listaOsob = json.fromJson(odp2, userListType2);
        }
        Biblioteka biblioteka = new Biblioteka("Publicznej");
    }
}
