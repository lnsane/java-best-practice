package com.best.spring.boot.session;

import com.best.spring.boot.session.event.ListenEent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王存露
 */
@SpringBootApplication
public class SpringBootSessionDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSessionDemo.class, args);
    }

    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter111(){
        ListenEent listenEent = new ListenEent();
        List<HttpSessionListener> listeners = new ArrayList<>();
        listeners.add(listenEent);
        return new SessionEventHttpSessionListenerAdapter(listeners);
    }
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher1() {
//        return new HttpSessionEventPublisher();
//    }


}
