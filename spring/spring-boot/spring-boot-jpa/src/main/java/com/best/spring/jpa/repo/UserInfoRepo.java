package com.best.spring.jpa.repo;

import com.best.spring.jpa.dao.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 王存露
 */
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {
}
