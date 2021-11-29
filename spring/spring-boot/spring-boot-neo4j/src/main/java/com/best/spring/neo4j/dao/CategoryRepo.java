package com.best.spring.neo4j.dao;

import com.best.spring.neo4j.model.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CategoryRepo extends Neo4jRepository<Category, String> {
}
