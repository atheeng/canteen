package com.fuseCanteen.canteen.service;

import com.fuseCanteen.canteen.model.FoodOrder;
import com.fuseCanteen.canteen.repository.FoodOrderRepository;
import com.fuseCanteen.canteen.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class Scheduler {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();

    @Scheduled(cron = "0 57 19 * * *")
    public void scheduleFoodOrder() {
        List<FoodOrder> foodOrderList = foodOrderRepository.findAllByOrderStatusAndScheduleDate(OrderStatus.SCHEDULE, LocalDate.parse(dtf.format(now)));
        List<FoodOrder> foodOrders=new ArrayList<>();
        for (FoodOrder foodOrder : foodOrderList) {
                foodOrder.setOrderStatus(OrderStatus.PENDING);
                foodOrders.add(foodOrder);
        }
        foodOrderRepository.saveAll(foodOrders);
        System.out.println("Scheduling is done");
    }
}
