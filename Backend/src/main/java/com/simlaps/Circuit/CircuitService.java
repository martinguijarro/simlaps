package com.simlaps.Circuit;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simlaps.Exception.ResourceNotFoundException;

@Service
public class CircuitService {
    
    private final CircuitRepository circuitRepository;

    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    // GET methods

    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }

    public ResponseEntity<Circuit> getCircuitById(String circuitId) throws ResourceNotFoundException {
        Circuit circuit = circuitRepository.findById(circuitId)
            .orElseThrow(() -> new ResourceNotFoundException("Circuit with id " + circuitId + " not found"));

        return ResponseEntity.ok().body(circuit);
    }

    // CREATE or UPDATE methods

    public ResponseEntity<Circuit> createCircuit(Circuit circuit) {
        return ResponseEntity.ok(circuitRepository.save(circuit));
    }

}
