package com.spring.boot.rocktmq.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
public class DelayLevelCalculate {
    private static List<Integer> defaultLevel = new ArrayList();

    public DelayLevelCalculate() {
    }

    public static Integer calculateDefault(long second, DataModel dataModel) {
        if (second <= 0L) {
            return 0;
        } else {
            for(int i = defaultLevel.size() - 1; i >= 0; --i) {
                long level = second / (long)(Integer)defaultLevel.get(i);
                if (level > 0L) {
                    dataModel.setRemainDelayTime(second - defaultLevel.get(i));
                    return i;
                }
            }

            return 0;
        }
    }

    static {
        defaultLevel.add(1);
        defaultLevel.add(5);
        defaultLevel.add(10);
        defaultLevel.add(30);
        defaultLevel.add(60);
        defaultLevel.add(120);
        defaultLevel.add(180);
        defaultLevel.add(300);
        defaultLevel.add(480);
        defaultLevel.add(600);
        defaultLevel.add(1200);
        defaultLevel.add(1800);
        defaultLevel.add(3600);
        defaultLevel.add(21600);
        defaultLevel.add(43200);
        defaultLevel.add(86400);
        defaultLevel.add(172800);
        defaultLevel.add(259200);
    }

}
