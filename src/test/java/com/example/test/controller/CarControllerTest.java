package com.example.test.controller;

import com.example.test.repository.CarRepository;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CarControllerTest {

    CarController carController;

    @Mock
    CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        carController = new CarController(carRepository);
    }

//    @Test
//    public void findAllCars() {
//        List<Car> expectedCarsFromRepository = new ArrayList<>();
//        expectedCarsFromRepository.add(new Car("Toyota Yaris", "NS-132-DS2",
//                new User("Marko", "Strisko")));
//
//
//        List<CarDTO> expectedCarsFromController = new ArrayList<>();
//        expectedCarsFromController.add(new CarDTO(1L, "Toyota Yaris", "NS-132-DS2", "Marko Strisko"));
//
//        when(carRepository.findAll()).thenReturn(expectedCarsFromRepository);
//
//        ResponseEntity<List<CarDTO>> getAllCarsResponse = carController.findAllCars();
//
//        assertEquals(getAllCarsResponse.getBody().size(), expectedCarsFromController.size());
//        assertEquals(getAllCarsResponse.getBody().stream().findFirst().get().getOwner(), expectedCarsFromController.stream().findFirst().get().getOwner());
//        assertEquals(getAllCarsResponse.getStatusCode(), HttpStatus.OK);
//        verify(carRepository, times(1)).findAll();
//    }
}