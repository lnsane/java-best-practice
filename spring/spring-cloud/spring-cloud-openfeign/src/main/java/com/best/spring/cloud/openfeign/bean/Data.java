package com.best.spring.cloud.openfeign.bean;

import java.io.Serializable;

/**
 * @author CunLu Wang
 * @since 2023/5/24
 */
public class Data<T>  implements Serializable {
    public T getS() {
        return s;
    }

    public void setS(T s) {
        this.s = s;
    }

    private T s;
}
