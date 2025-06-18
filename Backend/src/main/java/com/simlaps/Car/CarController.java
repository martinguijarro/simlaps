package com.simlaps.Car;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simlaps.Exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {
    
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // GET endpoints

    @GetMapping("/cars/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/id/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable String carId) throws ResourceNotFoundException {
        return carService.getCarById(carId);
    }

    // CREATE or UPDATE endpoints

    @PostMapping("/car/create")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        return carService.createCar(car);
    }

}
