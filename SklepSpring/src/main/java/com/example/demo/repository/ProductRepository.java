package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

// W tej wersji nie tylko korzystamy z gotowego interfejsu JpaRepository,
// ale jeszcze wzbogacamy go o dodatkowe metody.
// Nazwy tych metod mówią Springowi wg jakich kryteriów ma szukać rekordów.

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductName(String name);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByProductNameContainingAndPriceBetween(String name, BigDecimal min, BigDecimal max);

}



