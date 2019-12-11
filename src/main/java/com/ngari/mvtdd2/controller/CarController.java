package com.ngari.mvtdd2.controller;

import com.ngari.mvtdd2.dto.Car;
import com.ngari.mvtdd2.exception.BusException;
import com.ngari.mvtdd2.service.CarService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CarController {


    @Autowired
    CarService carService;


    @GetMapping(path = "/cars/{name}")
    public Car getCar_ReturnInfi(@PathVariable String name) {
        log.info("Here comes the name :{}",name);
        return carService.getByName(name);
    }



    @ExceptionHandler(BusException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private void BusExceptionHandler(BusException ex){}
}
