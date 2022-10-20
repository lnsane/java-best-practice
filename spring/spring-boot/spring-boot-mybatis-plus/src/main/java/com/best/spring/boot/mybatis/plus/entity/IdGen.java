package com.best.spring.boot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import org.springframework.stereotype.Component;

/**
 * @author CunLu Wang
 * @since 2022/9/22
 */
@Component
public class IdGen implements IKeyGenerator {
    @Override
    public String executeSql(String incrementerName) {
        return "1";
    }

}
