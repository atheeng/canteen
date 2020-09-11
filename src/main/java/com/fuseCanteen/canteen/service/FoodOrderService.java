package com.fuseCanteen.canteen.service;

import com.fuseCanteen.canteen.dto.FoodOrderDto;
import com.fuseCanteen.canteen.dto.OrderStatus;
import com.fuseCanteen.canteen.model.Food;
import com.fuseCanteen.canteen.model.FoodOrder;

import java.util.List;

public interface FoodOrderService {
    FoodOrder saveOrderFood(FoodOrderDto foodOrderDto);
    List<FoodOrder> getAllFoodOrderList();
    List<FoodOrder> getAllFoodOrderByOrderStatus(String status);
    List<FoodOrder> getAllFoodOrderByOrderDate(String date);
    List<FoodOrder> getAllFoodOrderByEmployeeId(Long id);
    FoodOrder update(FoodOrderDto foodOrderDto);
    FoodOrder cancelFoodOrder(Long foodOrderId);

}
