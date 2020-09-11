package com.fuseCanteen.canteen.controller.employee;

import com.fuseCanteen.canteen.dto.FoodOrderDto;
import com.fuseCanteen.canteen.dto.Response;
import com.fuseCanteen.canteen.dto.RestResponseDto;
import com.fuseCanteen.canteen.model.FoodOrder;
import com.fuseCanteen.canteen.repository.FoodOrderRepository;
import com.fuseCanteen.canteen.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/")
public class FoodOrderController {

    @Autowired
    private RestResponseDto restResponseDto;
    @Autowired
    private FoodOrderService foodOrderService;

    /**
     * all order list
     * @return
     */
    @GetMapping(value = "/foodOrder")
    public  ResponseEntity<RestResponseDto> getFoodOrderList() {
        try{
            List<FoodOrder> foodOrderList = foodOrderService.getAllFoodOrderList();
            if(foodOrderList.isEmpty()){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order list not found");
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully retrieved food order list");
                restResponseDto.setDetail(foodOrderList);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order list not found");
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     *
     * @param status
     * @return
     * for get order list by status
     */

    @GetMapping(value = "/foodOrder/{status}")
    public  ResponseEntity<RestResponseDto> getFoodOrderListByStatus(@PathVariable String status) {
        try{
            List<FoodOrder> foodOrderList = foodOrderService.getAllFoodOrderByOrderStatus(status);
            if(foodOrderList.isEmpty()){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order list not found by status "+status);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully retrieved food order list by "+status+" status");
                restResponseDto.setDetail(foodOrderList);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order list not found by status "+status);
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * get all list by corresponding employee Id
     * @param employeeId
     * @return
     */
    @GetMapping(value = "/foodOrder/{employeeId}")
    public  ResponseEntity<RestResponseDto> getFoodOrderListByEmployee(@PathVariable Long employeeId) {
        try{
            List<FoodOrder> foodOrderList = foodOrderService.getAllFoodOrderByEmployeeId(employeeId);
            if(foodOrderList.isEmpty()){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order list not found by employeeId "+employeeId);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully retrieved food order list by "+employeeId+" employeeId");
                restResponseDto.setDetail(foodOrderList);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order list not found by employeeId "+employeeId);
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     *
     * @param orderDate
     * @return
     */
    @GetMapping(value = "/foodOrder/{orderDate}")
    public  ResponseEntity<RestResponseDto> getFoodOrderListByOrderDate(@PathVariable String orderDate) {
        try{
            List<FoodOrder> foodOrderList = foodOrderService.getAllFoodOrderByOrderStatus(orderDate);
            if(foodOrderList.isEmpty()){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order list not found by orderDate "+orderDate);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully retrieved food order list by "+orderDate+" orderDate");
                restResponseDto.setDetail(foodOrderList);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order list not found by orderDate "+orderDate);
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * update food order
     * @param foodOrderDto
     * @return
     */
    @PutMapping(value = "/foodOrder")
    public  ResponseEntity<RestResponseDto> updateFoodOrder(@RequestBody FoodOrderDto foodOrderDto) {
        try{
            FoodOrder foodOrderUpdate = foodOrderService.update(foodOrderDto);
            if(foodOrderUpdate.getFood()==null){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order can not update");
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully update food order");
                restResponseDto.setDetail(foodOrderUpdate);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order can not update");
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * cancel food order
     * @param foodOrderId
     * @return
     */
    @PutMapping(value = "/foodOrder/{foodOrderId}")
    public  ResponseEntity<RestResponseDto> cancelFoodOrder(@PathVariable Long foodOrderId) {
        try{
            FoodOrder foodOrderUpdate = foodOrderService.cancelFoodOrder(foodOrderId);
            if(foodOrderUpdate.getFood()==null){
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("food order can not cancel");
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            }else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("successfully cancel food order");
                restResponseDto.setDetail(foodOrderUpdate);
                return ResponseEntity.ok(restResponseDto);
            }

        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("food order can not cancel");
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * order food save
     * @param foodOrderDto
     * @return
     */
    @PostMapping(value = "/foodOrder")
    public ResponseEntity<RestResponseDto> orderFood(@RequestBody FoodOrderDto foodOrderDto) {
        try {
            FoodOrder foodOrder = foodOrderService.saveOrderFood(foodOrderDto);
            if (foodOrder.getEmployee() == null) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food Order is not submit");
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Food Order submit by User "+foodOrder.getEmployee().getFirstName() +" for "+foodOrder.getFood().getName());
                restResponseDto.setDetail(foodOrder);
                return ResponseEntity.ok(restResponseDto);
            }
        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food Order is not submit");
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
