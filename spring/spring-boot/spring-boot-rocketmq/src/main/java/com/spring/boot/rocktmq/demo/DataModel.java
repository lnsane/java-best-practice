package com.spring.boot.rocktmq.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CunLu Wang
 * @since 2022/9/16
 */
public class DataModel {

    private Long remainDelayTime;

    public DataModel() {
    }

    public Long getRemainDelayTime() {
        return remainDelayTime;
    }

    public void setRemainDelayTime(Long remainDelayTime) {
        this.remainDelayTime = remainDelayTime;
    }

}
