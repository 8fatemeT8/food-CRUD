package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderFoodRepository extends CrudRepository<Order,Integer> {
    @Override
    Optional<Order> findById(Integer integer);
}
