package com.example.demo.rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/rest/products")
public class RProduct {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> readAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product readOne(@PathVariable("id") int id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono produktu od nr " + id);
        }
    }

    @GetMapping("/{id}/price")
    public BigDecimal getPrice(@PathVariable("id") int id) {
        return readOne(id).getPrice();
    }
    
    @PutMapping("/{id}/price")
    public void setPrice(@PathVariable("id") int id,
            @RequestBody BigDecimal newPrice) {
        Product product = readOne(id);
        product.setPrice(newPrice);
        repository.save(product);
    }
}








