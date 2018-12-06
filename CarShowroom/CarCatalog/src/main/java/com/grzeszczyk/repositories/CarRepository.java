package com.grzeszczyk.repositories;

import com.grzeszczyk.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
