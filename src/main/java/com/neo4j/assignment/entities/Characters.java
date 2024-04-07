package com.neo4j.assignment.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Data
public class Characters {

    @Id
    private String name;

    private String height;

    private String mass;

    private String skin_color;

    private String hair_color;

    private String eye_color;

    private String birth_year;

    private String gender;

    @Relationship(type = "FROM")
    private Planets homeworld;

    @Relationship(type = "IDENTIFIES_AS")
    private Species species;

}
