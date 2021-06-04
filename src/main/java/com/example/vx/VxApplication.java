package com.example.vx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.vx.mapper")
public class VxApplication {

    public static void main(String[] args) {
        SpringApplication.run(VxApplication.class, args);
    }

}
