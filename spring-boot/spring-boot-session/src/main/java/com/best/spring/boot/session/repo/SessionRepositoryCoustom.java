package com.best.spring.boot.session.repo;

import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

/**
 * @author 王存露
 */
public class SessionRepositoryCoustom implements SessionRepository {
    @Override
    public Session createSession() {
        return null;
    }

    @Override
    public void save(Session session) {

    }

    @Override
    public Session findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
