package com.neo4j.assignment.services;

import com.neo4j.assignment.entities.Planets;
import com.neo4j.assignment.entities.Species;
import com.neo4j.assignment.repositories.PlanetRepository;
import com.neo4j.assignment.repositories.SpeciesRepository;
import com.neo4j.assignment.requests.SpeciesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {

    @Autowired
    private PlanetRepository planetRepository ;

    @Autowired
    private SpeciesRepository speciesRepository ;


    public Species saveSpecies(SpeciesRequest request){

        Species species =  new Species() ;
        species.setName(request.getName());
        species.setClassification(request.getClassification());
        species.setDesignation(request.getDesignation());
        species.setAverage_height(request.getAverage_height());
        species.setSkin_colors(request.getSkin_colors());
        species.setHair_colors(request.getHair_colors());
        species.setEye_colors(request.getEye_colors());
        species.setAverage_lifespan(request.getAverage_lifespan());
        species.setLanguage(request.getLanguage());

        Planets homeland = planetRepository.findById(request.getHomeworld())
                .orElseThrow(() -> new RuntimeException("Homeland not found"));
        species.setHomeworld(homeland);

        return speciesRepository.save(species);

    }


}


