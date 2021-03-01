package com.cping.ricekitchenpos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cping.ricekitchenpos.dao")
public class RicekitchenposApplication {

    public static void main(String[] args) {
        SpringApplication.run(RicekitchenposApplication.class, args);
    }

}
