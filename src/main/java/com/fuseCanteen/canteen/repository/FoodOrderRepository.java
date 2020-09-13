package com.fuseCanteen.canteen.repository;

import com.fuseCanteen.canteen.util.OrderStatus;
import com.fuseCanteen.canteen.model.Employee;
import com.fuseCanteen.canteen.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
    List<FoodOrder> findAllByOrderStatus(OrderStatus orderStatus);
    List<FoodOrder> findAllByOrderStatusAndScheduleDate(OrderStatus orderStatus, LocalDate date);
    List<FoodOrder> findAllByOrderDate(String date);
    List<FoodOrder> findAllByEmployee(Employee employee);
}
