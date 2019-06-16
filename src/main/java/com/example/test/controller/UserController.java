package com.example.test.controller;

import com.example.test.dto.CarDTO;
import com.example.test.dto.UserDTO;
import com.example.test.repository.CarRepository;
import com.example.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> returnValues = this.userRepository.findAll()
                .stream().map(user -> new UserDTO(user.getId(), user.getFirstname(), user.getLastname())).collect(Collectors.toList());

        return ResponseEntity.ok(returnValues);
    }

    @GetMapping("/{userId}/cars")
    public ResponseEntity<List<CarDTO>> findAllUserCars(@PathVariable Long userId) {
        List<CarDTO> returnValues = this.carRepository.findByOwnerId(userId)
                .stream().map(car -> new CarDTO(car.getId(), car.getBrand(),
                        car.getLicensePlateNumber(), car.getOwner().getFirstname() + " " + car.getOwner().getLastname())).collect(Collectors.toList());

        return ResponseEntity.ok(returnValues);
    }
}
