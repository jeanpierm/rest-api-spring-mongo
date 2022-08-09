package com.jm.demo.abilities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AbilitiesService {

    private final AbilitiesRepository abilitiesRepository;

    public Collection<Ability> findAll() {
        return this.abilitiesRepository.findAll();
    }

    public Ability findById(String id) {
        return this.abilitiesRepository.findById(id).orElseThrow();
    }

    public Ability create(Ability ability) {
        return this.abilitiesRepository.save(ability);
    }
}
