package com.grzeszczyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class CarCatalogApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(CarCatalogApp.class, args);
        System.out.println( "CarCatalog START!" );
    }
}
