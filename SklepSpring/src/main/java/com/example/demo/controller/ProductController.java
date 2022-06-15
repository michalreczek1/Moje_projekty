package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.basket.Basket;
import com.example.demo.model.Product;
import com.example.demo.photo.PhotoUtil;
import com.example.demo.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public String readAll(Model model) {
        List<Product> products = repository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String readOne(Model model, @PathVariable("id") int productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product";
        } else {
            model.addAttribute("id", productId);
            return "missing_product";
        }
    }

    @GetMapping("/find")
    public String search(Model model, String name, BigDecimal min, BigDecimal max) {
        if (name != null || min != null || max != null) {
            if (min == null) {
                min = BigDecimal.ZERO;
            }
            if (max == null) {
                max = BigDecimal.valueOf(1000000000);
            }
            if (name == null) {
                name = "";
            }
            List<Product> products = repository.findByProductNameContainingAndPriceBetween(name, min, max);
            model.addAttribute("products", products);
        }
        return "wyszukiwarka";
    }

    @GetMapping("/{id}/add-to-basket")
    public String addToBasket(@PathVariable("id") int productId, @SessionAttribute Basket basket) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            basket.incrementProduct(product.get());
        }

        return "redirect:/products";
        // Po dodaniu produktu do koszyka przejdź na listę poduktów.
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute Product product) {

        return "product_form";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(Model model, @PathVariable("id") int productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product_form";
        } else {
            model.addAttribute("id", productId);
            return "missing_product";
        }
    }

    @PostMapping({ "/new", "/{id}/edit" })
    public String saveProduct(@Valid @ModelAttribute Product product,
            BindingResult bindingResult,
            Model model) {
        System.out.println("utworzony obiekt: " + product);
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product_form";
        } else {
            repository.save(product);
            System.out.println("zapisany obiekt: " + product);
            model.addAttribute("zapisano", true);
            return "redirect:/products/" + product.getProductId();
        }
        
    }
    
    // Gdy w klasie Product są adnotacje dot. walidacji, a obiekt nie spełnia wymagań, to:
    // - Hibernate wyrzuca wyjątek przy próbie zapisania tego obiektu do bazy, czyli tu jest wyjątek w repository.save(product)
    // - Gdy w metodzie kontrolera (np. saveProduct) przed parametrem jest adnotacja @Valid, ale nie ma parametru BindingResult,
    //   to Spring odrzuca zapytanie (kod 400) i w ogóle nie wywołuje tej metody. Nasza metoda w ogóle się nie wykonuje.
    // - Gdy metoda posiada także parametr typu BindingResult,
    //   to Spring zawsze wywoła naszą metodę, a w tym parametrze przekaze nam informację czy były błędy i jakie.

    @Autowired
    private PhotoUtil photoUtil;
    
    @GetMapping(path="/{id}/photo", produces="image/jpeg")
    @ResponseBody
    public byte[] getPhoto(@PathVariable("id") int productId) {
            return photoUtil.readPhoto(productId);
    }


    
    
}



