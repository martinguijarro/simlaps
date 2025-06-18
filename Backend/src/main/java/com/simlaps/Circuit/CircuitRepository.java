package com.simlaps.Circuit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends MongoRepository<Circuit, String> {
    
}
