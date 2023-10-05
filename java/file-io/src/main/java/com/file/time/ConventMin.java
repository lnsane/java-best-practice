package com.file.time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

/**
 * @author CunLu Wang
 * @since 2022/7/18
 */
public class ConventMin extends JFrame {

    public static void main(String[] args) throws AWTException, InterruptedException {

        while(true) {
            //robot关键对象
            Robot robot = new Robot ();
            robot.keyPress (17);
            robot.keyPress (9);
            robot.keyRelease (17);
            robot.keyRelease (9);
            int i = 0;
            while(i < 10) {
                robot.keyPress (112);
                robot.keyRelease (112);
                i++;
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }
    }
}
