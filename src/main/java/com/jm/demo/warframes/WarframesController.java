package com.jm.demo.warframes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(WarframesController.PATH)
@RequiredArgsConstructor
public class WarframesController {

    public final static String PATH = "/api/warframes";

    private final WarframesService warframesService;

    @GetMapping
    public ResponseEntity<Collection<Warframe>> getChampions() {
        Collection<Warframe> warframes = warframesService.getAll();
        return ResponseEntity.ok(warframes);
    }

    @GetMapping("{name}")
    public ResponseEntity<Warframe> getChampion(@PathVariable String name) {
        Warframe warframe = warframesService.getByName(name);
        return ResponseEntity.ok(warframe);
    }

    @PostMapping
    public ResponseEntity<Warframe> createChampion(@RequestBody Warframe warframe) {
        Warframe warframeCreated = warframesService.create(warframe);
        URI uri = URI.create(WarframesController.PATH + "/" + warframeCreated.getName());
        return ResponseEntity.created(uri).body(warframe);
    }

    @PostMapping("{name}/abilities")
    public ResponseEntity<Warframe> addAbilities(@PathVariable String name, @RequestBody List<String> abilityIds) {
        Warframe warframeUpdated = warframesService.addAbilities(name, abilityIds);
        return ResponseEntity.ok(warframeUpdated);
    }

    @PatchMapping("{name}")
    public ResponseEntity<Warframe> updateChampion(@PathVariable String name, @RequestBody Warframe warframe) {
        Warframe warframeUpdated = warframesService.update(name, warframe);
        return ResponseEntity.ok(warframeUpdated);
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Warframe> deleteChampion(@PathVariable String name) {
        warframesService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
