package com.best.spring.boot.web.controller;

/**
 * @author CunLu Wang
 * @since 2023/6/8
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class MyController {

    @GetMapping("/example")
    public void writeToResponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("Hello, World!");
        writer.flush();
        writer.close();
    }
}
