package com.jm.demo.warframes;

import com.jm.demo.abilities.AbilitiesRepository;
import com.jm.demo.abilities.Ability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarframesService {

    private final WarframesRepository warframesRepository;
    private final AbilitiesRepository abilitiesRepository;

    public Collection<Warframe> getAll() {
        return warframesRepository.findAll();
    }

    public Warframe getByName(String name) {
        return warframesRepository.findByName(name).orElseThrow();
    }

    public Warframe create(Warframe warframe) {
        return warframesRepository.save(warframe);
    }

    public Warframe update(String name, Warframe warframe) {
        Warframe warframeDocument = getByName(name);
        if (!Objects.isNull(warframe.getName())) warframeDocument.setName(warframe.getName());
        if (!Objects.isNull(warframe.getDifficulty())) warframeDocument.setDifficulty(warframe.getDifficulty());
        if (!Objects.isNull(warframe.getAbilities())) warframeDocument.setAbilities(warframe.getAbilities());
        if (!Objects.isNull(warframe.getRole())) warframeDocument.setRole(warframe.getRole());

        return warframesRepository.save(warframeDocument);
    }

    public void deleteByName(String name) {
        warframesRepository.deleteByName(name);
    }

    public Warframe addAbilities(String name, List<String> abilityIds) {
        Optional<Warframe> optionalWarframe = warframesRepository.findByName(name);
        if (optionalWarframe.isEmpty()) {
            return null;
        }
        Warframe warframeToUpdate = optionalWarframe.get();
        Set<Ability> abilitiesToAdd = abilityIds.stream()
                .map(abilitiesRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        warframeToUpdate.setAbilities(abilitiesToAdd);

        return warframesRepository.save(warframeToUpdate);
    }
}
