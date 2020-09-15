package com.montnets.bean;

/**
 * @author montnets
 */
public class MultiDynamicSendDetail {

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 该手机号码的消息
     */
    private Long msgid;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }
}
