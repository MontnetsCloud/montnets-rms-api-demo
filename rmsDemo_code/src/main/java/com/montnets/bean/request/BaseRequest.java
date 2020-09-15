package com.montnets.bean.request;


/**
 * 请求对象父类
 *
 * @author montnets
 */
public class BaseRequest {

    /**
     * 账号
     */
    protected String userid;

    /**
     * 密码
     */
    protected String pwd;

    /**
     * 时间戳
     */
    protected String timestamp;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
