package com.grzeszczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.grzeszczyk", "com.grzeszczyk.dealer.repositories", "com.grzeszczyk.dealer.services"})
@EnableJpaRepositories(basePackages = "com.grzeszczyk.dealer.repositories")

public class DealerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DealerApplication.class, args);
        System.out.printf("Dealer START!");
    }

}

