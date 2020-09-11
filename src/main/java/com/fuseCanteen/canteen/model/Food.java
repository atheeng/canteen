package com.fuseCanteen.canteen.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuseCanteen.canteen.dto.FoodCategory;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double perItemPrice;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String foodDay;
    @Enumerated(EnumType.STRING)
    FoodCategory foodCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPerItemPrice() {
        return perItemPrice;
    }

    public void setPerItemPrice(Double perItemPrice) {
        this.perItemPrice = perItemPrice;
    }

    public String getFoodDay() {
        return foodDay;
    }

    public void setFoodDay(String foodDay) {
        this.foodDay = foodDay;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
