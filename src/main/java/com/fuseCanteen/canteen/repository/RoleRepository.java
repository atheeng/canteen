package com.fuseCanteen.canteen.repository;

import com.fuseCanteen.canteen.dto.Authority;
import com.fuseCanteen.canteen.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role r where r.name=?1")
    Role findByName(Authority name);
}
