package com.simlaps.Lap;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LapService {
    
    private final LapRepository lapRepository;

    public LapService(LapRepository lapRepository) {
        this.lapRepository = lapRepository;
    }

    // GET methods

    public List<Lap> getAllLaps() {
        return lapRepository.findAll();
    }

    public List<Lap> getLapsByUserId(String userId) {
        return lapRepository.findByUserId(userId);
    }

    // CREATE or UPDATE methods

    public ResponseEntity<Lap> createLap(Lap lap) {
        return ResponseEntity.ok(lapRepository.save(lap));
    }

}
