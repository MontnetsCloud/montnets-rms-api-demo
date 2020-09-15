package com.montnets.bean.request.tpl;

import com.montnets.bean.RmsResource;
import com.montnets.bean.request.BaseRequest;

import java.util.List;

/**
 * 模板相关请求基础类
 * @author montnets
 */
public class TplRequest extends BaseRequest {

    /**
     * 模板有效期
     */
    private String expire;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 富信主题
     */
    private String title;

    /**
     * 富信资源列表
     */
    private List<RmsResource> reslist;

    /**
     * 数字签名
     */
    private String sign;

    /**
     * 自定义流水号
     */
    private String custid;

    /**
     * 模板备注
     */
    private String remarks;

    /**
     * 模板审批结果提醒对象
     */
    private String reminders;

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RmsResource> getReslist() {
        return reslist;
    }

    public void setReslist(List<RmsResource> reslist) {
        this.reslist = reslist;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReminders() {
        return reminders;
    }

    public void setReminders(String reminders) {
        this.reminders = reminders;
    }
}
