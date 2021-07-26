package com.best.spring.jpa.repo;

import com.best.spring.jpa.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 王存露
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findFirstByUserName(String fastUUID);

}
