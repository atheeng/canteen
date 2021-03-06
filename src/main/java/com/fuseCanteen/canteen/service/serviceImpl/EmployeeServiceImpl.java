package com.fuseCanteen.canteen.service.serviceImpl;

import com.fuseCanteen.canteen.util.Authority;
import com.fuseCanteen.canteen.dto.EmployeeDto;
import com.fuseCanteen.canteen.model.Employee;
import com.fuseCanteen.canteen.model.Role;
import com.fuseCanteen.canteen.repository.EmployeeRepository;
import com.fuseCanteen.canteen.repository.RoleRepository;
import com.fuseCanteen.canteen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.fuseCanteen.canteen.util.Authority.valueOf;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Employee save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setAddress(employeeDto.getAddress());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setUserName(employeeDto.getUserName());
        String role = employeeDto.getRoles();
        Role roles = roleRepository.findByName(Authority.getEnum(valueOf(role).toString()));
        employee.setRoles(Collections.singleton(roles));
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        Employee employee = employeeRepository.findById(id.longValue());
        employeeRepository.delete(employee);
        return true;
    }

    @Transactional
    @Override
    public Employee update(EmployeeDto employeeDto) {
        Employee employeeUpdate = employeeRepository.findById(employeeDto.getId().longValue());
        employeeUpdate.setFirstName(employeeDto.getFirstName());
        employeeUpdate.setLastName(employeeDto.getLastName());
        employeeUpdate.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employeeUpdate.setAddress(employeeDto.getAddress());
        employeeUpdate.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeUpdate.setUserName(employeeDto.getUserName());
        employeeRepository.save(employeeUpdate);
        return employeeUpdate;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id.longValue());
    }

    @Override
    public Employee getEmployeeByUserName(String username) {
        return employeeRepository.findByUserName(username);
    }
}
