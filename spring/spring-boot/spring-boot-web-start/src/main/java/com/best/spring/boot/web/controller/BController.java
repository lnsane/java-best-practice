package com.best.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 王存露
 */
@Component
public class BController {
    @Autowired
    private AController aController;

    public void a() {
        aController.b();
    }
}
