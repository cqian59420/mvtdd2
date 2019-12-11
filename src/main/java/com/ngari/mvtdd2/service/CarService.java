package com.ngari.mvtdd2.service;

import com.ngari.mvtdd2.dto.Car;
import com.ngari.mvtdd2.exception.BusException;
import com.ngari.mvtdd2.exception.CarNotFoundException;
import com.ngari.mvtdd2.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getByName(String name) {
        Car car = carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException("car not found");
        }
        return car;
    }
}
