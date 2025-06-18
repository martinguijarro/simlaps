package com.simlaps.Car;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simlaps.Exception.ResourceNotFoundException;

@Service
public class CarService {
    
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // GET methods

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public ResponseEntity<Car> getCarById(String carId) throws ResourceNotFoundException {
        Car car = carRepository.findById(carId)
            .orElseThrow(() -> new ResourceNotFoundException("Car with id " + carId + " not found"));

        return ResponseEntity.ok().body(car);
    }

    // CREATE or UPDATE methods

    public ResponseEntity<Car> createCar(Car car) {
        return ResponseEntity.ok(carRepository.save(car));
    }

}
