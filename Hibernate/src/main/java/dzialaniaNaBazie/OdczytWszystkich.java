package dzialaniaNaBazie;
import entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class OdczytWszystkich  {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();

            TypedQuery<Products> query = em.createNamedQuery("Products.findAll", Products.class);
            List<Products> products = query.getResultList();
            for (Products product : products) {
                System.out.println(product.getProductName().toUpperCase() + " za cenę " + product.getPrice()+ " zł");
                System.out.println(product.getDescription().toLowerCase());
            }
            em.close();
            emf.close();
        }

    }
