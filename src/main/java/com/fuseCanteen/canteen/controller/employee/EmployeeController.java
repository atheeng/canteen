package com.fuseCanteen.canteen.controller.employee;

import com.fuseCanteen.canteen.dto.EmployeeDto;
import com.fuseCanteen.canteen.util.Response;
import com.fuseCanteen.canteen.dto.RestResponseDto;
import com.fuseCanteen.canteen.model.Employee;
import com.fuseCanteen.canteen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    RestResponseDto restResponseDto;

    /**
     * get employee list
     * @return
     */

    @GetMapping(value = "/employee")
    public ResponseEntity<RestResponseDto> getAllEmployee() {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList();
            if (employeeList.size() == 0) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Employee list is not available");
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Retrieved");
                restResponseDto.setDetail(employeeList);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Employee List is not Found");
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * delete employee
     * @param id
     * @return
     */
    @DeleteMapping(value = "/employee{id}")
    public ResponseEntity<RestResponseDto> deleteEmployee(@PathVariable Long id) {
        try {
            boolean data = employeeService.delete(id);
            if (data==false) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Can not delete");
                restResponseDto.setDetail(null);
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

    /**
     * get by employee id
     * @param id
     * @return
     */
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<RestResponseDto> getByEmployeeId(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee.getLastName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Employee  is not available by Id " +id);
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Retrieved");
                restResponseDto.setDetail(employee);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Employee is not Found by Id "+id);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * save employee
     * @param employeeDto
     * @param bindingResult
     * @return
     */
    @PostMapping(path = "/employee")
    public ResponseEntity<RestResponseDto> saveEmployee(@Validated @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<ObjectError> objectErrors=bindingResult.getAllErrors();
            restResponseDto.setDetail(objectErrors);
            restResponseDto.setMessage("Validation Error");
            restResponseDto.setResponse(Response.VALIDATION_ERROR);
            return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
        }
        try {
            Employee data = employeeService.save(employeeDto);
            if (data.getFirstName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Employee  is not save by Name " + data.getFirstName() +" "+data.getLastName());
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully Saved with name " + data.getFirstName() +" "+data.getLastName());
                restResponseDto.setDetail(data);
                return ResponseEntity.ok(restResponseDto);
            }

        } catch (Exception e) {
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Employee is not Saved by name " + employeeDto.getFirstName() +" "+employeeDto.getLastName());
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * update employee
     * @param employeeDto
     * @return
     */
    @PutMapping(path = "/employee")
    public ResponseEntity<RestResponseDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
        try{
            Employee data = employeeService.update(employeeDto);
            if (data.getLastName().isEmpty()) {
                restResponseDto.setResponse(Response.NO_INFORMATION);
                restResponseDto.setMessage("Employee  is not update by Name " + data.getFirstName() +" "+data.getLastName());
                restResponseDto.setDetail(null);
                return new ResponseEntity<>(restResponseDto, HttpStatus.BAD_REQUEST);
            } else {
                restResponseDto.setResponse(Response.SUCCESS);
                restResponseDto.setMessage("Successfully updated with name " + data.getFirstName() +" "+data.getLastName());
                restResponseDto.setDetail(data);
                return ResponseEntity.ok(restResponseDto);
            }
        }catch (Exception e){
            restResponseDto.setResponse(Response.FAILURE);
            restResponseDto.setMessage("Employee is not updated by name " + employeeDto.getFirstName() +" "+employeeDto.getLastName());
            restResponseDto.setDetail(null);
            return new ResponseEntity<>(restResponseDto, HttpStatus.EXPECTATION_FAILED);
        }
    }


}
