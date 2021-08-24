package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.FieldValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FieldValueRepo extends Neo4jRepository<FieldValue, String> {
}
