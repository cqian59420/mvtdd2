package com.ngari.mvtdd2.service;

import com.ngari.mvtdd2.dto.Car;
import com.ngari.mvtdd2.exception.BusException;
import com.ngari.mvtdd2.exception.CarNotFoundException;
import com.ngari.mvtdd2.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {


    @Mock
    CarRepository carRepository;

    CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    void getInfo_ReturnInfo() {
        given(carRepository.findByName(anyString())).willReturn(new Car("Honda", "RED"));

        Car carByName = carService.getByName("name");

        assertEquals("RED",carByName.getColor());
        assertEquals("Honda",carByName.getName());

    }




    @Test
    void getInfo_ReturnCarNotInRepository() {

        given(carRepository.findByName(anyString())).willReturn(null);

        assertThrows(CarNotFoundException.class,() -> carService.getByName("xssadaa"));

    }
}