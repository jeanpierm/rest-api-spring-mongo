package com.jm.demo.warframes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WarframesRepository extends MongoRepository<Warframe, String> {

    Optional<Warframe> findByName(String name);

    void deleteByName(String name);
}
