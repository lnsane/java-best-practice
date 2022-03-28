package com.best.spring.boot.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class DemoController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/hello/{str}")
    public String hello(@PathVariable("str") String str){
        return getLang(str);
    }

    public static void main(String[] args) {
        System.out.println(Locale.CHINA.toString());
    }

    public String getLang(String msgKey) {
        try {
            Locale locale = Locale.CHINA;
            if (msgKey.equals("1")) {
                locale = Locale.CHINA;
            } else if (msgKey.equals("2")) {
                locale = Locale.US;
            }
            return messageSource.getMessage("finance.message.paymentmanage.notFound", null, locale);
        } catch (Exception e) {
            return msgKey;
        }
    }
}
