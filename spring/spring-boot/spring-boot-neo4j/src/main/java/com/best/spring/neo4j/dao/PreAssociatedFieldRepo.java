package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.PreAssociatedField;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PreAssociatedFieldRepo extends Neo4jRepository<PreAssociatedField, Long> {
}
