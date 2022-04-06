package com.best.spring.boot.easy.excel;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DemoController {
    @PostMapping(value = "/hello")
    public void hello(HttpServletRequest request,
                      @RequestPart("file")MultipartFile file){
        try {
            List<Demo> upcDTOList = EasyExcel.read(file.getInputStream()).head(Demo.class).sheet().doReadSync();
            System.out.println(upcDTOList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
