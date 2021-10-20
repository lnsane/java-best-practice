package com.strategy.patterm.demo.bean;

/**
 * 华距商品
 */
public class HuaJuGoods extends BaseGoods {
    private String companyId;
    private String companyName;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "HuaJuGoods{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                "} " + super.toString();
    }
}
