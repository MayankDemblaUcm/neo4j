package com.neo4j.assignment.repositories;

import com.neo4j.assignment.entities.Characters;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends Neo4jRepository<Characters, String> {
}
