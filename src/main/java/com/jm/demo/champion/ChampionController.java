package com.jm.demo.champion;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(ChampionController.PATH)
@RequiredArgsConstructor
public class ChampionController {

    public final static String PATH = "/api/champions";

    private final ChampionService championService;

    @GetMapping
    public ResponseEntity<Collection<Champion>> getChampions() {
        Collection<Champion> champions = championService.getAll();
        return ResponseEntity.ok(champions);
    }

    @GetMapping("{name}")
    public ResponseEntity<Champion> getChampion(@PathVariable String name) {
        Champion champion = championService.getByName(name);
        return ResponseEntity.ok(champion);
    }

    @PostMapping
    public ResponseEntity<Champion> createChampion(@RequestBody Champion champion) {
        Champion championCreated = championService.create(champion);
        URI uri = URI.create(ChampionController.PATH + "/" + championCreated.getName());
        return ResponseEntity.created(uri).body(champion);
    }

    @PatchMapping("{name}")
    public ResponseEntity<Champion> updateChampion(@PathVariable String name, @RequestBody Champion champion) {
        Champion championUpdated = championService.update(name, champion);
        return ResponseEntity.ok(championUpdated);
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Champion> deleteChampion(@PathVariable String name) {
        championService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
