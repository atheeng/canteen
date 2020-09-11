package com.fuseCanteen.canteen.service;
import com.fuseCanteen.canteen.dto.EmployeeDto;
import com.fuseCanteen.canteen.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(EmployeeDto employeeDto);

    List<Employee> getEmployeeList();

    boolean delete(Long id);

    Employee update(EmployeeDto employeeDto);

    Employee getEmployeeById(Long id);
}
