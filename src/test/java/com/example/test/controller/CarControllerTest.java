package com.example.test.controller;

import com.example.test.dto.CarDTO;
import com.example.test.model.Car;
import com.example.test.model.User;
import com.example.test.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CarControllerTest {

    CarController carController;

    @Mock
    CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        carController = new CarController(carRepository);
    }

    @Test
    public void findAllCars() {
        List<Car> expectedCarsFromRepository = new ArrayList<>();
        expectedCarsFromRepository.add(new Car("Toyota Yaris", "NS-132-DS2",
                new User("Marko", "Strisko")));


        List<CarDTO> expectedCarsFromController = new ArrayList<>();
        expectedCarsFromController.add(new CarDTO(1L, "Toyota Yaris", "NS-132-DS2", "Marko Strisko"));

        when(carRepository.findAll()).thenReturn(expectedCarsFromRepository);

        List<CarDTO> getAllCarsResponse = carController.findAllCars();

        assertEquals(getAllCarsResponse.size(), expectedCarsFromController.size());
        assertEquals(getAllCarsResponse.stream()
                .findFirst()
                .get()
                .getOwner(), expectedCarsFromController.stream()
                .findFirst()
                .get()
                .getOwner());
        verify(carRepository, times(1)).findAll();
    }
}