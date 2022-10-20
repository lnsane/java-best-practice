package com.spring.boot.map.struct.demo3;

import com.spring.boot.map.struct.MapStructApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.BootstrapWith;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MapStructApplication.class)
@Slf4j
class CarTest {

    @Autowired
    private CarCopy carCopy;

    @Test
    public void test(){
        Car car = new Car();
        car.setName("123");
        car.setLocalDateTime(LocalDateTime.now());
        car.setLocalDate(LocalDate.now());
        car.setMoney(new BigDecimal("1.1211"));

        System.out.println(carCopy.copy(car));
        log.info("-----");
    }
}