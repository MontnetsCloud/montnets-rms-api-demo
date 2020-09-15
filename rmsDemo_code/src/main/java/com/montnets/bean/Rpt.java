package com.montnets.bean;

/**
 * 状态报告实体
 *
 * @author montnets
 */
public class Rpt {

    /**
     * 消息流水号
     */
    private Long msgid;

    /**
     * 自定义流水号
     */
    private String custid;

    /**
     * 当前条数
     */
    private Integer pknum;

    /**
     * 总条数
     */
    private Integer pktotal;

    /**
     * 手机号
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
     * 发送时间
     */
    private String stime;

    /**
     * 返回时间
     */
    private String rtime;

    /**
     * 接收状态
     */
    private Integer status;

    /**
     * 错误代码
     */
    private String errcode;

    /**
     * 错误代码描述
     */
    private String errdesc;

    /**
     * 自定义拓展数据
     */
    private String exdata;

    /**
     * 信息类型
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public Integer getPknum() {
        return pknum;
    }

    public void setPknum(Integer pknum) {
        this.pknum = pknum;
    }

    public Integer getPktotal() {
        return pktotal;
    }

    public void setPktotal(Integer pktotal) {
        this.pktotal = pktotal;
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

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrdesc() {
        return errdesc;
    }

    public void setErrdesc(String errdesc) {
        this.errdesc = errdesc;
    }

    public String getExdata() {
        return exdata;
    }

    public void setExdata(String exdata) {
        this.exdata = exdata;
    }
}
