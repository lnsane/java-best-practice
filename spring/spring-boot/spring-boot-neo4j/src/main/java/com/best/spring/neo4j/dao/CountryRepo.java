package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.Country;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CountryRepo extends Neo4jRepository<Country, String> {
}
