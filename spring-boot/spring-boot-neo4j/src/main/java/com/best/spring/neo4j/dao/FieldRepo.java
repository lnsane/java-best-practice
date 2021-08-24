package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.Field;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FieldRepo extends Neo4jRepository<Field, String> {
}
