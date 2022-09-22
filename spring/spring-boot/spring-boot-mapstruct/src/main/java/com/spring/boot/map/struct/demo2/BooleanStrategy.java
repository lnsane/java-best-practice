package com.spring.boot.map.struct.demo2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.mapstruct.BeanMapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@AllArgsConstructor(access = AccessLevel.MODULE)
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
    @BeanMapping(ignoreByDefault = true)
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
