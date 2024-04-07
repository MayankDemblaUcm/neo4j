package com.neo4j.assignment.controller;

import com.neo4j.assignment.entities.Characters;
import com.neo4j.assignment.repositories.CharacterRepository;
import com.neo4j.assignment.requests.CharacterRequest;
import com.neo4j.assignment.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterService characterService ;

    // Create a new character
    @PostMapping
    public Characters createCharacter(@RequestBody CharacterRequest character) {
        return characterService.saveCharacters(character);
    }

    // Retrieve all characters
    @GetMapping
    public List<Characters> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Retrieve a specific character by ID
    @GetMapping("/{name}")
    public Characters getCharacterById(@PathVariable("name") String name) {
        Optional<Characters> characterOptional = characterRepository.findById(name);
        return characterOptional.orElse(null);
    }

    // Update an existing character
    @PutMapping("/{name}")
    public Characters updateCharacter(@PathVariable("name") String name,
                                      @RequestBody Characters updatedCharacter) {
        Optional<Characters> characterOptional = characterRepository.findById(name);
        if (characterOptional.isPresent()) {
            Characters character = characterOptional.get();
            character.setName(updatedCharacter.getName());
            character.setHeight(updatedCharacter.getHeight());
            character.setMass(updatedCharacter.getMass());
            character.setSkin_color(updatedCharacter.getSkin_color());
            character.setHair_color(updatedCharacter.getHair_color());
            character.setEye_color(updatedCharacter.getEye_color());
            character.setBirth_year(updatedCharacter.getBirth_year());
            character.setGender(updatedCharacter.getGender());
            character.setHomeworld(updatedCharacter.getHomeworld());
            character.setSpecies(updatedCharacter.getSpecies());
            return characterRepository.save(character);
        }
        return null;
    }

    // Delete a character by ID
    @DeleteMapping("/{name}")
    public void deleteCharacter(@PathVariable("name") String name) {
        characterRepository.deleteById(name);
    }

}
