package com.neo4j.assignment.requests;

import com.neo4j.assignment.entities.Planets;
import lombok.Data;

@Data
public class SpeciesRequest {

    private String name;

    private String classification;

    private String designation;

    private String average_height;

    private String skin_colors;

    private String hair_colors;

    private String eye_colors;

    private String average_lifespan;

    private String language;

    private String homeworld;

}
