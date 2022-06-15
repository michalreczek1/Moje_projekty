package dzialaniaNaBazie;

import entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ModyfikacjaDanych {
    public static void main(String[] args) {
        int id = 2;
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Products product = em.find(Products.class, id);
        if (product == null) {
            System.out.println("Nie ma takiego produktu" + id);
            return;
        }
        System.out.println("Znaleziono " + product);
        System.out.println(product.getProductName());

        System.out.println("Podaj nową nazwę produktu: ");
        String nazwa = scanner.nextLine();
        product.setProductName(nazwa);

        System.out.println(product.getProductName().toUpperCase() + " " + product.getDescription().toLowerCase());

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
