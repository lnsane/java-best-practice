package com.spring.boot.rocktmq.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
public class Delay {
    private static List<Integer> levelList = new ArrayList();

    public Delay() {
    }

    public static Integer calculateDefault(long second, Data dataModel) {
        if (second <= 0L) {
            return 0;
        } else {
            for(int i = levelList.size() - 1; i >= 0; --i) {
                long level = second / (long) levelList.get(i);
                if (level > 0L) {
                    dataModel.setRemainDelayTime(second - levelList.get(i));
                    return i;
                }
            }

            return 0;
        }
    }

    static {
        levelList.add(0);
        levelList.add(1);
        levelList.add(5);
        levelList.add(10);
        levelList.add(30);
        levelList.add(60);
        levelList.add(120);
        levelList.add(180);
        levelList.add(300);
        levelList.add(480);
        levelList.add(600);
        levelList.add(1200);
        levelList.add(1800);
        levelList.add(3600);
        levelList.add(21600);
        levelList.add(43200);
        levelList.add(86400);
        levelList.add(172800);
        levelList.add(259200);
    }

}
