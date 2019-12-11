package com.ngari.mvtdd2;


import com.ngari.mvtdd2.controller.CarController;
import com.ngari.mvtdd2.dto.Car;
import com.ngari.mvtdd2.exception.BusException;
import com.ngari.mvtdd2.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    CarService carService;

    @Test
    void testCard_shouldreturn() throws Exception {

        given(carService.getByName(anyString())).willReturn(new Car("Bird", "red"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/honda")).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Bird"))
                .andExpect(jsonPath("color").value("red"));
    }

    @Test
    void testMvcNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/honda")).andExpect(status().isNotFound());
    }

    @Test
    void test_forbidden() throws Exception {
        given(carService.getByName(anyString())).willThrow(BusException.class);

        mockMvc.perform(MockMvcRequestBuilders.get( "/cars/null")).andExpect(status().is5xxServerError());


    }
}
