package com.example.demo.repository;

import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.model.Food;

import java.util.List;

public interface FoodModelRepositoryCustom {

    List<Food> searchByContainNameAndPrice(FoodSearchJson foodSearchJson);

    List<Food> findByName(String name);



}
