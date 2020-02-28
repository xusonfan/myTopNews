package com.dyt.mytoplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MytoplistApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytoplistApplication.class, args);
    }

}
