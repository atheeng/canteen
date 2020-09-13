package com.fuseCanteen.canteen.controller.admin;

import com.fuseCanteen.canteen.util.Response;
import com.fuseCanteen.canteen.dto.RestResponseDto;
import com.fuseCanteen.canteen.model.Food;
import com.fuseCanteen.canteen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/api")
public class FoodController {
    @Autowired
    private FoodService foodservice;
    @Autowired
    private RestResponseDto restResponseDto;

    /**
     * get list food for day
     * @param
     * @return
     */
    @GetMapping(path = "/food/list/day")
    public ResponseEntity<RestResponseDto> foodListForToday() {
        try {
            List<Food> foodList = foodservice.getFoodListForToday();
            if (foodList.size() == 0) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food list is not available");
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Retrieved for today");
                restResponseDto.setDetail(foodList);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food List is not Found");
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }


    /**
     * food list display
     * @return
     */
    @GetMapping(path = "/food")
    public ResponseEntity<RestResponseDto> allFoodList() {
        try {
            List<Food> foodList = foodservice.getFoodList();
            if (foodList.size() == 0) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food list is not available");
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Retrieved");
                restResponseDto.setDetail(foodList);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food List is not Found");
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * get food by id
     * @param id
     * @return
     */
    @GetMapping(path = "/food/{id}")
    public ResponseEntity<RestResponseDto> getFoodById(@PathVariable Long id) {
        try {
            Food food = foodservice.getFoodById(id);
            if (food == null) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food  is not available Id " + id);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Retrieved");
                restResponseDto.setDetail(food);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food is not Find by Id " + id);
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * save food menu
     * @param food
     * @return
     */
    @PostMapping(path = "/food")
    public ResponseEntity<RestResponseDto> saveFood(@RequestBody Food food) {
        try {
            Food data = foodservice.save(food);
            if (data.getName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food  is not save by Name " + food.getName());
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Saved with name " + food.getName());
                restResponseDto.setDetail(food);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food is not Saved by name " + food.getName());
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * update food
     * @param food
     * @return
     */
    @PutMapping(path = "/food")
    public ResponseEntity<RestResponseDto> updateOrSaveFood(@RequestBody Food food) {
        try {
            Food data = foodservice.save(food);
            if (data.getName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food  is not update by Name " + food.getName());
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully update with name " + food.getName());
                restResponseDto.setDetail(food);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food is not update by name " + food.getName());
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * update food day by food id
     * save to updateOrSaveFood
     * @param foodId
     * @return
     */
    @PutMapping(path = "/food/{foodId}")

    public ResponseEntity<RestResponseDto> updateFoodForTodayById(@PathVariable Long foodId) {
        try {
            Food data = foodservice.updateByForToday(foodId);
            if (data.getName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Food  is not update for day by Id" + foodId);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully update with Id " + foodId);
                restResponseDto.setDetail(foodId);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Food is not update by Id " + foodId);
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * delete food
     * @param id
     * @return
     */
    @DeleteMapping(path = "/food/{id}")
    public ResponseEntity<RestResponseDto> deleteFood(@PathVariable Long id) {
        try {
            boolean data = foodservice.delete(id);
            if (data == false) {
                restResponseDto.setResponse(Response.BAD_REQUEST);
                restResponseDto.setDetail(null);
                restResponseDto.setMessage("Can not Deleted by Id " + id);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully deleted");
                restResponseDto.setDetail(null);
                return ResponseEntity.ok(restResponseDto);
            }
        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Can not delete");
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
