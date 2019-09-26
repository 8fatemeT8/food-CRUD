package com.example.demo.repository;

import com.example.demo.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food,Integer> {
    @Override
    void deleteById(Integer integer);

    @Override
    Iterable<Food> findAll();

    @Override
    Optional<Food> findById(Integer integer);

}
