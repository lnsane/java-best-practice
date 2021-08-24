package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.Platform;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PlatformRepo extends Neo4jRepository<Platform, String> {
}
