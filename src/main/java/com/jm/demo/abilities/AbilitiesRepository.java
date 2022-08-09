package com.jm.demo.abilities;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbilitiesRepository extends MongoRepository<Ability, String> {
}
