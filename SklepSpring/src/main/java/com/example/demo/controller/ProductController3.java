package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository3;

// W tej wersji controller nie korzysta bezpośrednio z EntityManagera, tylko z klasy typu Repository.
// Dzięki temu w Controllerze nie ma kodów SQL i szczegółów dostępu do danych.

@Controller
@RequestMapping("/products3")
public class ProductController3 {
    @Autowired
    private ProductRepository3 repository;

    @GetMapping
    public String readAll(Model model) {
        List<Product> products = repository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String readOne(Model model, @PathVariable("id") int productId) {
        Product product = repository.findById(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/find")
    public String search(Model model, String name, BigDecimal min, BigDecimal max) {
        if(name != null || min != null || max != null) {
            if(min == null) {
                min = BigDecimal.ZERO;
            }
            if(max == null) {
                max = BigDecimal.valueOf(1000000000);
            }
            if(name == null) {
                name = "";
            }
            List<Product> products = repository.findByCriteria(name, min, max);
            model.addAttribute("products", products);
        }
        return "wyszukiwarka";
    }

}



