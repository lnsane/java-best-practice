package com.best.spring.boot.mongodb.repo;

import com.best.spring.boot.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 王存露
 */
public interface UserRepo extends MongoRepository<User, String> {

}
