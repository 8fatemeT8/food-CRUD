package com.example.demo.servis;

import com.example.demo.Utils.FoodInfo;
import com.example.demo.Utils.FoodSearchJson;
import com.example.demo.Utils.MenuJson;
import com.example.demo.function.BaseMethod;
import com.example.demo.model.Food;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.FoodModelRepositoryCustom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Service extends BaseMethod {
    private FoodRepository mfR;
    private FoodModelRepositoryCustom mFRC;

    public Service(FoodRepository mFR, FoodModelRepositoryCustom mFRC) {
        this.mfR = mFR;
        this.mFRC = mFRC;
    }


    public List<Food> findById(int id) {
        List<Food> foodModelList = new ArrayList<>();
        Optional<Food> op = mfR.findById(id);
        foodModelList.add(op.isPresent() ? op.get() : null);
        return foodModelList;
    }

    public boolean deleteById(int id) {
        List<Food> foods = findById(id);
        if (foods.get(0) != null) {
            mfR.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean create(Food food) {
        List<Food> list = mFRC.findByName(food.getName());
        if (list.isEmpty()) {
            mfR.save(food);
            return true;
        }
        return false;
    }

    public boolean update(Food food) {
        List<Food> foods = findById(food.getId());
        if (foods.size() == 1) {
            mfR.save(food);
            return true;
        }
        return false;
    }


    public FoodInfo getDetail(int id) {
        if (String.valueOf(id).matches("^[0-9][0-9 -]*$")) {
            List<Food> foods = findById(id);
            if (foods.size() == 1) {
                Food menufoodModel = findById(id).get(0);
                FoodInfo foodInfo = setFoodInfo(menufoodModel);
                return foodInfo;
            }
            return null;
        }
        return null;
    }

    public MenuJson getFoods(FoodSearchJson foodSearchJson) {
        return new MenuJson(getFood(mFRC.searchByContainNameAndPrice(foodSearchJson)));
    }

    public MenuJson food(FoodSearchJson parentJson){
        if (parentJson.getId()!=0){
            List<FoodInfo> foodInfoList=new ArrayList<>();
            foodInfoList.add(getDetail(parentJson.getId()));
            return new MenuJson(foodInfoList);
        }
        return getFoods(parentJson);
    }
}