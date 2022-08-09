package com.jm.demo.abilities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(AbilitiesController.PATH)
@RequiredArgsConstructor
public class AbilitiesController {

    public final static String PATH = "/api/abilities";

    private final AbilitiesService abilitiesService;

    @GetMapping
    public ResponseEntity<Collection<Ability>> findAll() {
        Collection<Ability> abilities = abilitiesService.findAll();
        return ResponseEntity.ok(abilities);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ability> findById(@PathVariable String id) {
        Ability ability = abilitiesService.findById(id);
        return ResponseEntity.ok(ability);
    }

    @PostMapping
    public ResponseEntity<Ability> create(@RequestBody Ability ability) {
        Ability abilityCreated = abilitiesService.create(ability);
        URI uri = URI.create(AbilitiesController.PATH + "/" + abilityCreated.getId());
        return ResponseEntity.created(uri).body(ability);
    }

}
