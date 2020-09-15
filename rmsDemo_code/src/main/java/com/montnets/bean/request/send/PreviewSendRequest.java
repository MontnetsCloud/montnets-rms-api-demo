package com.montnets.bean.request.send;

import com.montnets.bean.RmsResource;

import java.util.List;

/**
 * 预览发送
 * @author montnets
 */
public class PreviewSendRequest extends SendRequest {

    /**
     * 富信主题
     */
    private String title;

    /**
     * 数字签名
     */
    private String sign;

    /**
     * 富信资源列表
     */
    private List<RmsResource> reslist;

    /**
     * 富信类型
     */
    private String rmstype;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<RmsResource> getReslist() {
        return reslist;
    }

    public void setReslist(List<RmsResource> reslist) {
        this.reslist = reslist;
    }

    public String getRmstype() {
        return rmstype;
    }

    public void setRmstype(String rmstype) {
        this.rmstype = rmstype;
    }
}
