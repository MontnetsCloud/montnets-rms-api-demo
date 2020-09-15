package com.montnets.bean.request.send;

import com.montnets.bean.request.BaseRequest;

/**
 * 富信发送实体
 * @author montnets
 */
public class SendRequest extends BaseRequest {

    /**
     * 模板 id
     */
    private String tplid;

    /**
     * 要发送的手机号
     */
    private String mobile;

    /**
     * 拓展号
     */
    private String exno;

    /**
     * 用户自定义流水号
     */
    private String custid;

    /**
     * 自定义拓展数据
     */
    private String exdata;

    /**
     * 业务类型
     */
    private String svrtype;

    /**
     * 富信有效期
     */
    private String expire;

    /**
     * 补发短信内容
     */
    private String suppmsg;

    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExno() {
        return exno;
    }

    public void setExno(String exno) {
        this.exno = exno;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getExdata() {
        return exdata;
    }

    public void setExdata(String exdata) {
        this.exdata = exdata;
    }

    public String getSvrtype() {
        return svrtype;
    }

    public void setSvrtype(String svrtype) {
        this.svrtype = svrtype;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getSuppmsg() {
        return suppmsg;
    }

    public void setSuppmsg(String suppmsg) {
        this.suppmsg = suppmsg;
    }
}
