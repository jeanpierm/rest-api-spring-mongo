package com.jm.demo.champion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ChampionService {

    private final ChampionRepository championRepository;

    public Collection<Champion> getAll() {
        return championRepository.findAll();
    }

    public Champion getByName(String name) {
        return championRepository.findByName(name).orElseThrow();
    }

    public Champion create(Champion champion) {
        return championRepository.save(champion);
    }

    public Champion update(String name, Champion champion) {
        Champion championDocument = getByName(name);
        if (!Objects.isNull(champion.getName())) championDocument.setName(champion.getName());
        if (!Objects.isNull(champion.getDifficulty())) championDocument.setDifficulty(champion.getDifficulty());
        if (!Objects.isNull(champion.getAbilities())) championDocument.setAbilities(champion.getAbilities());
        if (!Objects.isNull(champion.getRole())) championDocument.setRole(champion.getRole());

        return championRepository.save(championDocument);
    }

    public void deleteByName(String name) {
        championRepository.deleteByName(name);
    }
}
