package com.fuseCanteen.canteen.repository;

import com.fuseCanteen.canteen.dto.FoodCategory;
import com.fuseCanteen.canteen.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Food getById(Long id);
    List<Food> findAllByFoodCategory(FoodCategory foodCategory);
    List<Food> findAllByFoodDay(String date);
}
