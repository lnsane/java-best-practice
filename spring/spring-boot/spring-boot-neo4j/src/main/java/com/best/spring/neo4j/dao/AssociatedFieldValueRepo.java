package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.AssociatedFieldValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AssociatedFieldValueRepo extends Neo4jRepository<AssociatedFieldValue, String> {
}
