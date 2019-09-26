package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class FoodOrderJson {


    @JsonProperty("Orders")
    private List<OrderJson> Orders = new ArrayList<>();

    public List<OrderJson> getOrders() {
        return Orders;
    }

    public void setOrders(List<OrderJson> orders) {
        Orders = orders;
    }
}
