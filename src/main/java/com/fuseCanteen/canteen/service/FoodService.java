package com.fuseCanteen.canteen.service;

import com.fuseCanteen.canteen.model.Food;

import java.util.List;

public interface FoodService {
    Food save(Food food);

    List<Food> getFoodList();

    List<Food> getFoodListForToday();

    Food updateByForToday(Long foodId);

    Food update(Food food);

    boolean delete(Long id);

    Food getFoodById(Long id);
    Food getByName(String foodName);
}
