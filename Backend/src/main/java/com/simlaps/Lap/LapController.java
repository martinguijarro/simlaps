package com.simlaps.Lap;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LapController {
    
    private final LapService lapService;

    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    // GET endpoints

    @GetMapping("laps/all")
    public List<Lap> getAllLaps() {
        return lapService.getAllLaps();
    }

    @GetMapping("/laps/user/id/{userId}")
    public List<Lap> getLapsByUserId(@PathVariable String userId) {
        return lapService.getLapsByUserId(userId);
    }
    

    // CREATE or UPDATE endpoints
    
    @PostMapping("/lap/create")
    public ResponseEntity<Lap> createLap(@Valid @RequestBody Lap lap) {
        return lapService.createLap(lap);
    }
    

}
