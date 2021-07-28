package com.best.spring.boot.elastic.search.repo;

import com.best.spring.boot.elastic.search.model.User;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 王存露
 */
public interface UserRepo extends ElasticsearchRepository<User,Long> {
}
