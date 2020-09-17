package com.fuseCanteen.canteen.service.serviceImpl;

import com.fuseCanteen.canteen.dto.FoodOrderDto;
import com.fuseCanteen.canteen.util.OrderStatus;
import com.fuseCanteen.canteen.model.Employee;
import com.fuseCanteen.canteen.model.Food;
import com.fuseCanteen.canteen.model.FoodOrder;
import com.fuseCanteen.canteen.repository.EmployeeRepository;
import com.fuseCanteen.canteen.repository.FoodOrderRepository;
import com.fuseCanteen.canteen.repository.FoodRepository;
import com.fuseCanteen.canteen.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodOrderServiceImpl implements FoodOrderService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Override
    public FoodOrder saveOrderFood(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = new FoodOrder();
        Employee employee = employeeRepository.findById(foodOrderDto.getEmployee().longValue());
        Food food = foodRepository.getById(foodOrderDto.getFood());
        foodOrder.setScheduleDate(foodOrderDto.getScheduleDate());
        foodOrder.setEmployee(employee);
        foodOrder.setFood(food);
        foodOrder.setOrderStatus(OrderStatus.getEnum(foodOrderDto.getOrderStatus()));
        foodOrder.setOrderDate(foodOrderDto.getOrderDate());
        foodOrder.setTotalItem(foodOrderDto.getTotalItem());
        foodOrder.setItemRate(food.getPerItemPrice());
        foodOrder.setTotalAmount(food.getPerItemPrice() * foodOrderDto.getTotalItem());
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public List<FoodOrder> getAllFoodOrderList() {
        return foodOrderRepository.findAll();
    }

    @Override
    public List<FoodOrder> getAllFoodOrderByOrderStatus(String status) {
        return foodOrderRepository.findAllByOrderStatus(OrderStatus.valueOf(status));
    }

    @Override
    public List<FoodOrder> getAllFoodOrderByOrderDate(String date) {
        return foodOrderRepository.findAllByOrderDate(date);
    }

    @Override
    public List<FoodOrder> getAllFoodOrderByEmployeeId(Long id) {
        Employee employee = employeeRepository.findById(id.longValue());
        return foodOrderRepository.findAllByEmployee(employee);
    }

    @Override
    public FoodOrder update(FoodOrderDto foodOrderDto) {

        FoodOrder foodOrder = foodOrderRepository.getOne(foodOrderDto.getId());
        Employee employee = employeeRepository.findById(foodOrderDto.getEmployee().longValue());
        Food food = foodRepository.getById(foodOrderDto.getFood());
        foodOrder.setEmployee(employee);
        foodOrder.setScheduleDate(foodOrderDto.getScheduleDate());
        foodOrder.setFood(food);
        foodOrder.setOrderStatus(OrderStatus.getEnum(foodOrderDto.getOrderStatus()));
        foodOrder.setOrderDate(foodOrderDto.getOrderDate());
        foodOrder.setTotalItem(foodOrderDto.getTotalItem());
        foodOrder.setItemRate(food.getPerItemPrice());
        foodOrder.setTotalAmount(food.getPerItemPrice() * foodOrderDto.getTotalItem());
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public FoodOrder cancelFoodOrder(Long foodOrderId) {
        FoodOrder foodOrder = foodOrderRepository.getOne(foodOrderId);
        foodOrder.setOrderStatus(OrderStatus.CANCEL);
        return foodOrderRepository.save(foodOrder);
    }
}
