package com.best.spring.boot.session.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.session.Session;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.stereotype.Component;

/**
 * @author 王存露
 */
@Component
public class SessionEvent {
    private final static Logger log = LoggerFactory.getLogger(SessionEvent.class);

//    @EventListener(classes = HttpSessionCreatedEvent.class)
//    public void create(HttpSessionCreatedEvent httpSessionCreatedEvent) {
//        log.info("create");
//        HttpSession session = httpSessionCreatedEvent.getSession();
//        String id = session.getId();
//        log.info(id);
//    }
    @EventListener(classes = SessionCreatedEvent.class)
    public void create2(SessionCreatedEvent sessionCreatedEvent) {
        log.info("create2");
        Session session = sessionCreatedEvent.getSession();
        session.setAttribute("name","wangcunlu");
        for (String attributeName : session.getAttributeNames()) {
            Object name = session.getAttribute(attributeName);
            log.info(name.toString());
        }
        String id = session.getId();
        log.info(id);
    }
    @EventListener(classes = SessionDestroyedEvent.class)
    public void destroyedEvent(SessionDestroyedEvent sessionDestroyedEvent) {
        log.info("destroyedEvent");
        Session session = sessionDestroyedEvent.getSession();
        for (String attributeName : session.getAttributeNames()) {
            Object name = session.getAttribute(attributeName);
            log.info(name.toString());
        }
        String id = session.getId();
        log.info(id);
    }
    @EventListener(classes = SessionDeletedEvent.class)
    public void deletedEvent(SessionDeletedEvent sessionDeletedEvent) {
        log.info("deletedEvent");
        Session session = sessionDeletedEvent.getSession();
        for (String attributeName : session.getAttributeNames()) {
            Object name = session.getAttribute(attributeName);
            log.info(name.toString());
        }
        String id = session.getId();
        log.info(id);
    }
    @EventListener(classes = SessionExpiredEvent.class)
    public void expiredEvent(SessionExpiredEvent sessionExpiredEvent) {
        log.info("expiredEvent");
        Session session = sessionExpiredEvent.getSession();
        for (String attributeName : session.getAttributeNames()) {
            Object name = session.getAttribute(attributeName);
            log.info(name.toString());
        }
        String id = session.getId();
        log.info(id);
    }

//    @EventListener
//    public void destory(HttpSessionDestroyedEvent httpSessionDestroyedEvent) {
//        log.info("destory");
//        HttpSession session = httpSessionDestroyedEvent.getSession();
//    }
//    @EventListener
//    public void change(HttpSessionIdChangedEvent httpSessionIdChangedEvent) {
//        log.info("change");
//        String newSessionId = httpSessionIdChangedEvent.getNewSessionId();
//        String oldSessionId = httpSessionIdChangedEvent.getOldSessionId();
//
//    }
}
