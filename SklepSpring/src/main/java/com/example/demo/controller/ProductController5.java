package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository5;

// W tej wersji korzystamy z automatycznie wygenerowanego repozytorium na podstawie interfejsu JpaRepository.
// Używamy tylko standardowych metod.

@Controller
@RequestMapping("/products5")
public class ProductController5 {
    @Autowired
    private ProductRepository5 repository;

    @GetMapping
    public String readAll(Model model) {
        List<Product> products = repository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String readOne(Model model, @PathVariable("id") int productId) {
        Optional<Product> product = repository.findById(productId);
        if(product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product";
    }
}



