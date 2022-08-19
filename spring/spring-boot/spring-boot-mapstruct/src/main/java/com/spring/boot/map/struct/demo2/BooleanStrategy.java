package com.spring.boot.map.struct.demo2;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BooleanStrategy {

    @Named("1234")
    public String inchsTsoCentissmeter(String s){
        return "";
    }

    /**
     * 去空格
     *
     * @param str
     * @return
     */
    @Named("123")
    public String doTrim(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return str.trim();
    }

    @Named("EnglishToGerman")
     public String translateTitleEG(String title) {
        return "";
    }

    @Named("GermanToEnglish")
     public String translateTitleGE(String title) {
        return "";

    }
}
