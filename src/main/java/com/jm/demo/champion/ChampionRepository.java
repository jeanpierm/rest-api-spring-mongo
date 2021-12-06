package com.jm.demo.champion;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChampionRepository extends MongoRepository<Champion, String> {

    Optional<Champion> findByName(String name);

    void deleteByName(String name);
}
