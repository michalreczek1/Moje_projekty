package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;

// W tej wersji kontroler bezpośrednio korzysta z obiektu EntityManager.
// EM jest odstarczany przez Springa na podstawie konfiguracji projektu.

@Controller
public class ProductController1 {
    @Autowired
    private EntityManager em;
    
    @RequestMapping("/products1")
    public String readAll(Model model) {
        TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
        List<Product> products = query.getResultList();
        model.addAttribute("products", products);
        return "products";
    }
    
    // fragment adresu umieszczony w nawiasach {klamrowych} oznacza, że to jest część zmienna.
    // Można się do tego odwołać za pomocą specjalnego parametru oznaczonego w Springu @PathVariable.
    @RequestMapping("/products1/{id}")
    public String readOne(Model model, @PathVariable int id) {
        Product product = em.find(Product.class, id);
        model.addAttribute("product", product);
        return "product";
    }
    
    @RequestMapping("/products1/find")
    public String search(Model model, String name, BigDecimal min, BigDecimal max) {
        // Gdy nie podano parametrów (bo jest to wejście na stronę lub formularz był pusty),
        // to nie wyświetlamy żadnych produktów.
        
        // Tylko jeśli jest podany chociaż jeden parametr, tylko wtedy wyszukujemy produkty.
        if(name != null || min != null || max != null) {
            // Jeśli nie są podane min lub max, to przyjmujemy domyślne wartości.
            if(min == null) {
                min = BigDecimal.ZERO;
            }
            if(max == null) {
                max = BigDecimal.valueOf(1000000000);
            }
            if(name == null) {
                name = "";
            }
        
            final String sql = "SELECT p FROM Product p"
                    + " WHERE lower(p.productName) LIKE '%' || :name || '%'"
                    + "   AND p.price BETWEEN :min AND :max";
            TypedQuery<Product> query = em.createQuery(sql, Product.class);
            query.setParameter("name", name.trim().toLowerCase());
            query.setParameter("min", min);
            query.setParameter("max", max);
            List<Product> products = query.getResultList();
            model.addAttribute("products", products);
        }
        return "wyszukiwarka";
    }
    
}



