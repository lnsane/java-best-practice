package com.file.time;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author CunLu Wang
 * @since 2022/7/18
 */
public class ConventMin {
    public static void main(String[] args) {
        int sec = 340;
        BigDecimal divide = new BigDecimal(String.valueOf(sec)).divide(new BigDecimal(60), 2, RoundingMode.HALF_UP);
        String s = divide.toString();
        System.out.println(s);
        System.out.println(divide.doubleValue() * 60);
        System.out.println((int) (divide.doubleValue() * 60));
    }
}
