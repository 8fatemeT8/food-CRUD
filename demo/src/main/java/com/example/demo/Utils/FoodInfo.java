package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class FoodInfo {

    @JsonProperty("id")
    private int Id;
    @JsonProperty("name")
    private String Name;
    @JsonProperty("price")
    private int Price;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("type")
    private int type;
    @JsonProperty("time")
    private Instant time;

    public FoodInfo() {
    }

    public FoodInfo(String name, int price, int type, Instant time) {
        Name = name;
        Price = price;
        this.type = type;
        this.time = time;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
