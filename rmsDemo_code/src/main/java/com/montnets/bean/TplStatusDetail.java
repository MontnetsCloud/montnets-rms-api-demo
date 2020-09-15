package com.montnets.bean;


/**
 * 模板状态详情
 *
 * @author montnets
 */
public class TplStatusDetail {

    /**
     * 运营商
     */
    private String carrier;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 状态描述
     */
    private String desc;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
