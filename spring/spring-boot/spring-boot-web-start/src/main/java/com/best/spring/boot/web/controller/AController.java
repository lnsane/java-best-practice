package com.best.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 王存露
 */
@Component
public class AController {
    @Autowired
    private BController bController;

    public void b() {
        bController.a();
    }
}
