package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Tworzymy repository do obsługi rekordów typu Product, których kluczem jest Integer.
// Spring automatycznie stworzy implementację tego interfejsu i obiekt , który bedziemożna użycnp. w kontrolerze
@Repository
public interface ProductRepository5 extends JpaRepository <Product, Integer> {



}
