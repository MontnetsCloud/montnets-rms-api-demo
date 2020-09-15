package com.montnets.bean.response.tpl;

import com.montnets.bean.response.BaseResponse;

/**
 * 模板上传响应类
 * @author montnets
 */
public class TemplateResponse extends BaseResponse {

    /**
     * 自定义流水号
     */
    private String custid;

    /**
     * 模板 id
     */
    private String tplid;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }
}
