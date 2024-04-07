package com.neo4j.assignment.controller;

import com.neo4j.assignment.entities.Species;
import com.neo4j.assignment.repositories.SpeciesRepository;
import com.neo4j.assignment.requests.SpeciesRequest;
import com.neo4j.assignment.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository ;

    @Autowired
    private SpeciesService speciesService ;

    // Create a new species
    @PostMapping
    public Species createSpecies(@RequestBody SpeciesRequest species) {
        return speciesService.saveSpecies(species) ;
    }

    // Retrieve all species
    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    // Retrieve a specific species by ID
    @GetMapping("/{name}")
    public Species getSpeciesById(@PathVariable("name") String name) {
        Optional<Species> speciesOptional = speciesRepository.findById(name);
        return speciesOptional.orElse(null);
    }

    // Update an existing species
    @PutMapping("/{name}")
    public Species updateSpecies(@PathVariable("name") String name, @RequestBody Species updatedSpecies) {
        Optional<Species> speciesOptional = speciesRepository.findById(name);
        if (speciesOptional.isPresent()) {
            Species species = speciesOptional.get();
            species.setName(updatedSpecies.getName());
            species.setClassification(updatedSpecies.getClassification());
            species.setDesignation(updatedSpecies.getDesignation());
            species.setAverage_height(updatedSpecies.getAverage_height());
            species.setSkin_colors(updatedSpecies.getSkin_colors());
            species.setHair_colors(updatedSpecies.getHair_colors());
            species.setEye_colors(updatedSpecies.getEye_colors());
            species.setAverage_lifespan(updatedSpecies.getAverage_lifespan());
            species.setLanguage(updatedSpecies.getLanguage());
            species.setHomeworld(updatedSpecies.getHomeworld());
            return speciesRepository.save(species);
        }
        return null;
    }

    // Delete a species by ID
    @DeleteMapping("/{name}")
    public void deleteSpecies(@PathVariable("name") String name) {
        speciesRepository.deleteById(name);
    }

}
