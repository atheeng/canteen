package com.fuseCanteen.canteen.dto;

import com.fuseCanteen.canteen.model.Role;
import com.fuseCanteen.canteen.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                Role admin=new Role(Authority.ADMIN);
                Role employee=new Role(Authority.EMPLOYEE);
                roleList.add(admin);
                roleList.add(employee);
                roleRepository.saveAll(roleList);
            }
        }catch (Exception e){
            System.out.println("e");
        }

    }
}
