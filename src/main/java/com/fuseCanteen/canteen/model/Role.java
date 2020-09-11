package com.fuseCanteen.canteen.model;

import com.fuseCanteen.canteen.dto.Authority;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Authority name;
   public Role(){
       super();
    }

    public Role(Authority name) {
        this.name= name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Authority getName() {
        return name;
    }

    public void setName(Authority name) {
        this.name = name;
    }
}
