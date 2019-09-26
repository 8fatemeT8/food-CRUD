package com.example.demo.function;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.model.Food;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseMethod {


    public static List<FoodInfo> getFood(List<Food> menufoodModels) {
        List<FoodInfo> foodInfoList = new ArrayList<>();
        for (int i = 0; i < menufoodModels.size(); i++) {
            Food mfm = menufoodModels.get(i);
            FoodInfo foodInfo = new FoodInfo();
            foodInfo.setId(mfm.getId());
            foodInfo.setName(mfm.getName());
            foodInfo.setPrice(mfm.getPrice());
            foodInfo.setType(Integer.valueOf(mfm.getType()));
            foodInfo.setTime(mfm.getTimeSet());
            foodInfoList.add(foodInfo);
        }
        return foodInfoList;
    }

    public static List<Food> convertToMenuFood(Iterator<Food> iterator) {
        List<Food> foods = new ArrayList<>();
        while (iterator.hasNext()) {
            foods.add(iterator.next());
        }
        return foods;
    }

    public FoodInfo setFoodInfo(Food menufoodModel) {
        FoodInfo foodInfo = new FoodInfo();
        foodInfo.setName(menufoodModel.getName());
        foodInfo.setPrice(menufoodModel.getPrice());
        foodInfo.setType(Integer.valueOf(menufoodModel.getType()));
        foodInfo.setTime(menufoodModel.getTimeSet());
        foodInfo.setId(menufoodModel.getId());
        return foodInfo;
    }


    public ResponseEntity<String> getStringResponseEntity(FoodInfo foodInfo, JSONObject jsonObject) throws JSONException {
        jsonObject.put("name", foodInfo.getName());
        jsonObject.put("price", foodInfo.getPrice());
        jsonObject.put("type", foodInfo.getType());
        jsonObject.put("id", foodInfo.getId());
        jsonObject.put("dateObject", foodInfo.getTime());
        return ResponseEntity.ok(jsonObject.toString());
    }



}
