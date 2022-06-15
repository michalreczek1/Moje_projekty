package dzialaniaNaBazie;

import entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OdczytRekordu {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		System.out.println("Mam Entity Managera" + em);
		
		int szukaneId = 2;
		
		Products product = em.find(Products.class, szukaneId);
		if(product == null) {
			System.out.println("Nie ma takiego produktu");
		} else {
			System.out.println("Jest produkt: " + product + "!!!");
			System.out.println(product.getProductName() + " za cenę " + product.getPrice());
			System.out.println(product.getDescription());
		}
		em.close();
		emf.close();

	}

}
