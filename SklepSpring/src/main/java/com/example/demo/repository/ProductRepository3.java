package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

// Repository to komponent (czyli klasa w aplikacji springowej) odpowiedzialny za operacje bazodanowe.
// W tej wersji implementujemy to Repository samodzielnie.

@Repository
public class ProductRepository3 {
    @Autowired
    private EntityManager em;

    public List<Product> findAll() {
        TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    public Product findById(int productId) {
        return em.find(Product.class, productId);
    }

    public List<Product> findByCriteria(String name, BigDecimal min, BigDecimal max) {
        final String sql = "SELECT p FROM Product p"
                + " WHERE lower(p.productName) LIKE '%' || :name || '%'"
                + "   AND p.price BETWEEN :min AND :max";
        TypedQuery<Product> query = em.createQuery(sql, Product.class);
        query.setParameter("name", name.trim().toLowerCase());
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

}



