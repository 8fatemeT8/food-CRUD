package com.example.demo.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MenuJson {


    @JsonProperty("menu")
    private List<FoodInfo> Menu;
    @JsonProperty("count")
    private int count;


    public List<FoodInfo> getMenu() {
        return Menu;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMenu(List<FoodInfo> menu) {
        this.Menu = menu;
        this.count = menu.size();

    }

    public MenuJson(List<FoodInfo> menu) {
        this.Menu = menu;
        this.count = menu.size();

    }

    public MenuJson() {
    }

}
