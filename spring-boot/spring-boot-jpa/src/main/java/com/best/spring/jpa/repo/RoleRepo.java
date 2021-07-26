package com.best.spring.jpa.repo;

import com.best.spring.jpa.dao.Role;
import com.best.spring.jpa.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 王存露
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findFirstByRole(String fastUUID);
}
