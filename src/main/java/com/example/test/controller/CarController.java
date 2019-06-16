package com.example.test.controller;

import com.example.test.dto.CarDTO;
import com.example.test.exception.DataNotValidException;
import com.example.test.model.Car;
import com.example.test.model.User;
import com.example.test.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public List<CarDTO> findAllCars() {
        return this.carRepository.findAll()
                .stream()
                .map(car -> new CarDTO(car.getId(), car.getBrand(), car.getLicensePlateNumber(),
                        car.getOwner().getFirstname() + " " + car.getOwner().getLastname()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity createCar(@Valid @RequestBody CarDTO newCar, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorsMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                log.error(objectError.toString());
                errorsMessages.append(objectError.toString());
            });

            throw new DataNotValidException(errorsMessages.toString());
        }

        String[] splittedName = newCar.getOwner().split(" ");
        String firstName = splittedName[0];
        String lastName = splittedName[1];
        User newUser = new User(firstName, lastName);

        return new ResponseEntity(carRepository.save(new Car(newCar.getBrand(), newCar.getLicensePlateNumber(), newUser)), HttpStatus.CREATED);
    }
}
