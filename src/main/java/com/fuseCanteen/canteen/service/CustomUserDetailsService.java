package com.fuseCanteen.canteen.service;

import com.fuseCanteen.canteen.model.Employee;
import com.fuseCanteen.canteen.model.UserPrincipal;
import com.fuseCanteen.canteen.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findAllByUserName(username);
        if (employee == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(employee);
    }

}
