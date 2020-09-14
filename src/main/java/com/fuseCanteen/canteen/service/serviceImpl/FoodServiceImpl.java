package com.fuseCanteen.canteen.service.serviceImpl;

import com.fuseCanteen.canteen.model.Food;
import com.fuseCanteen.canteen.repository.FoodRepository;
import com.fuseCanteen.canteen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();

    @Override
    public Food save(Food food) {
        Food data = foodRepository.save(food);
        return data;
    }

    @Override
    public List<Food> getFoodList() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getFoodListForToday() {
        return foodRepository.findAllByFoodDay(dtf.format(now));
    }

    @Override
    public Food updateByForToday(Long foodId) {
        Food food = foodRepository.getOne(foodId);
        LocalDateTime now = LocalDateTime.now();
        food.setFoodDay(dtf.format(now));
        return foodRepository.save(food);
    }

    @Override
    public Food update(Food food) {
        return foodRepository.save(food);
    }


    @Override
    public boolean delete(Long id) {
        Food food = foodRepository.getOne(id);
        foodRepository.delete(food);
        return true;
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepository.getById(id);
    }

    @Override
    public Food getByName(String foodName) {
        return foodRepository.findByName(foodName);
    }

}
