package com.grzeszczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
public class App 
{

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);

    }
}
