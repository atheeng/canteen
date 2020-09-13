package com.fuseCanteen.canteen.service;

import com.fuseCanteen.canteen.model.Role;
import com.fuseCanteen.canteen.repository.RoleRepository;
import com.fuseCanteen.canteen.util.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbInit {
    @Autowired
    private RoleRepository roleRepository;


    @PostConstruct
    private void postConstruct() {
        List<Role> roleList=new ArrayList<>();
        try{
            List<Role> roles=roleRepository.findAll();
            if(roles.size()==0){
                Role admin=new Role(Authority.ROLE_ADMIN);
                Role employee=new Role(Authority.ROLE_ADMIN);
                roleList.add(admin);
                roleList.add(employee);
                roleRepository.saveAll(roleList);
            }
        }catch (Exception e){
            System.out.println("e");
        }
    }
}
