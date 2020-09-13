package com.fuseCanteen.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CanteenApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanteenApplication.class, args);
    }


}
