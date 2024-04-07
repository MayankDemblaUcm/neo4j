package com.neo4j.assignment.repositories;

import com.neo4j.assignment.entities.Planets;
import com.neo4j.assignment.entities.Species;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends Neo4jRepository<Planets, String> {
}
