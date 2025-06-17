package com.simlaps.Lap;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapRepository extends MongoRepository<Lap, String> {
    
    List<Lap> findByUserId(String userId);

}
