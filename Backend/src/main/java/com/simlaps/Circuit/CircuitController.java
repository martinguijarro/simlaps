package com.simlaps.Circuit;

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
public class CircuitController {
    
    private final CircuitService circuitService;

    public CircuitController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    // GET endpoints

    @GetMapping("/circuits/all")
    public List<Circuit> getAllCircuits() {
        return circuitService.getAllCircuits();
    }

    @GetMapping("/circuit/id/{circuitId}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable String circuitId) throws ResourceNotFoundException {
        return circuitService.getCircuitById(circuitId);
    }

    // CREATE or UPDATE endpoints

    @PostMapping("/circuit/create")
    public ResponseEntity<Circuit> createCircuit(@Valid @RequestBody Circuit circuit) {
        return circuitService.createCircuit(circuit);
    }

}
