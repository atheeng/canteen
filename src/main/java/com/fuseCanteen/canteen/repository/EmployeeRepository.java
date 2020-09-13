package com.fuseCanteen.canteen.repository;

import com.fuseCanteen.canteen.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findById(long id);
    Employee findAllByUserName(String username);
}
