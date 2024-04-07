package com.neo4j.assignment.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Data
public class Species {

    @Id
    private String name;

    private String classification;

    private String designation;

    private String average_height;

    private String skin_colors;

    private String hair_colors;

    private String eye_colors;

    private String average_lifespan;

    private String language;

    @Relationship(type = "ORIGINATED_FROM")
    private Planets homeworld;


}
