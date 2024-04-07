package com.neo4j.assignment.controller;

import com.neo4j.assignment.entities.Planets;
import com.neo4j.assignment.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    // Create a new planet
    @PostMapping
    public Planets createPlanet(@RequestBody Planets planet) {
        return planetRepository.save(planet);
    }

    // Retrieve all planets
    @GetMapping
    public List<Planets> getAllPlanets() {
        return planetRepository.findAll();
    }

    // Retrieve a specific planet by ID
    @GetMapping("/{name}")
    public Planets getPlanetById(@PathVariable("name") String name) {
        Optional<Planets> planetOptional = planetRepository.findById(name);
        return planetOptional.orElse(null);
    }

    // Update an existing planet
    @PutMapping("/{name}")
    public Planets updatePlanet(@PathVariable("name") String name, @RequestBody Planets updatedPlanet) {
        Optional<Planets> planetOptional = planetRepository.findById(name);
        if (planetOptional.isPresent()) {
            Planets planet = planetOptional.get();
            planet.setName(updatedPlanet.getName());
            planet.setRotation_period(updatedPlanet.getRotation_period());
            planet.setOrbital_period(updatedPlanet.getOrbital_period());
            planet.setDiameter(updatedPlanet.getDiameter());
            planet.setClimate(updatedPlanet.getClimate());
            planet.setGravity(updatedPlanet.getGravity());
            planet.setTerrain(updatedPlanet.getTerrain());
            planet.setSurface_water(updatedPlanet.getSurface_water());
            planet.setPopulation(updatedPlanet.getPopulation());
            return planetRepository.save(planet);
        }
        return null;
    }

    // Delete a planet by ID
    @DeleteMapping("/{name}")
    public void deletePlanet(@PathVariable("name") String name) {
        planetRepository.deleteById(name);
    }

}
