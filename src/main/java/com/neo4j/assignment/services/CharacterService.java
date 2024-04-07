package com.neo4j.assignment.services;

import com.neo4j.assignment.entities.Characters;
import com.neo4j.assignment.entities.Planets;
import com.neo4j.assignment.entities.Species;
import com.neo4j.assignment.repositories.CharacterRepository;
import com.neo4j.assignment.repositories.PlanetRepository;
import com.neo4j.assignment.repositories.SpeciesRepository;
import com.neo4j.assignment.requests.CharacterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository repository ;

    @Autowired
    PlanetRepository planetRepository ;

    @Autowired
    SpeciesRepository speciesRepository ;

    public Characters saveCharacters(CharacterRequest characterRequest){

        Characters character = new Characters();
        character.setName(characterRequest.getName());
        character.setHeight(characterRequest.getHeight());
        character.setMass(characterRequest.getMass());
        character.setSkin_color(characterRequest.getSkin_color());
        character.setHair_color(characterRequest.getHair_color());
        character.setEye_color(characterRequest.getEye_color());
        character.setBirth_year(characterRequest.getBirth_year());
        character.setGender(characterRequest.getGender());

        // Look up the homeland (planet) entity by name
        Planets homeland = planetRepository.findById(characterRequest.getHomeworld())
                .orElseThrow(() -> new RuntimeException("Homeland not found"));
        character.setHomeworld(homeland);

        // Look up the species entity by name
        Species species = speciesRepository.findById(characterRequest.getSpecies())
                .orElseThrow(() -> new RuntimeException("Species not found"));
        character.setSpecies(species);


        return repository.save(character) ;
    }

}
