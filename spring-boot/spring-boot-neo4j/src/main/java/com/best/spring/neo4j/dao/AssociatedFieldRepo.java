package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.AssociatedField;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AssociatedFieldRepo extends Neo4jRepository<AssociatedField, String> {
}
