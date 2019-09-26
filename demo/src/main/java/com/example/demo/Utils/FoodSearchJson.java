package com.example.demo.Utils;


import java.time.Instant;

public class FoodSearchJson  {
    private int id;
    private String name;
    private int toPrice;
    private int fromPrice;
    private Instant toDate;
    private Instant fromDate;
    private  int type;
    private int page;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getToPrice() {
        return toPrice;
    }

    public void setToPrice(int toPrice) {
        this.toPrice = toPrice;
    }

    public int getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(int fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Instant getToDate() {
        return toDate;
    }

    public void setToDate(Instant toDate) {
        this.toDate = toDate;
    }

    public Instant getFromDate() {
        return fromDate;
    }

    public void setFromDate(Instant fromDate) {
        this.fromDate = fromDate;
    }

    public FoodSearchJson(String name, int toPrice, int fromPrice, Instant toDate, Instant fromDate, int page) {
        this.name = name;
        this.toPrice = toPrice;
        this.fromPrice = fromPrice;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.page = page;
    }

    public FoodSearchJson(String name, int page, int price) {
        this.name = name;
        this.page = page;
        this.price = price;
    }

    public FoodSearchJson() {
    }
}
