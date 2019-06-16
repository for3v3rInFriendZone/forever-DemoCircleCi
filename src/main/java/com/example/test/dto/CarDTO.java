package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements Serializable {
    private Long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String brand;

    @Size(min = 8, max = 255)
    private String licensePlateNumber;

    @NotBlank
    private String owner;
}
