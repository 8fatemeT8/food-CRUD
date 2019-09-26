package com.example.demo.repository;

import com.example.demo.Utils.OrderJson;
import com.example.demo.model.Food;
import com.example.demo.model.Order;

public interface OrderFoodModelRepositoryCustom {

    Order findByFoodId(int id);

    void addOrder(OrderJson order, Food menufoodModel);

    void updateOrder(Order orderfoodModel);

}
