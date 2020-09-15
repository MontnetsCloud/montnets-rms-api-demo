package com.montnets.bean;

/**
 * 上行 bean
 *
 * @author montnets
 */
public class Mo {

    /**
     * 消息流水号
     */
    private Long msgid;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 通道号
     */
    private String spno;

    /**
     * 拓展号
     */
    private String exno;

    /**
     * 接收时间
     */
    private String rtime;

    /**
     * 信息类型
     */
    private String type;

    /**
     * 信息内容
     */
    private String content;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpno() {
        return spno;
    }

    public void setSpno(String spno) {
        this.spno = spno;
    }

    public String getExno() {
        return exno;
    }

    public void setExno(String exno) {
        this.exno = exno;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
