package com.montnets.bean.request.tpl;

import com.montnets.bean.request.BaseRequest;

/**
 * 模板状态查询
 * @author montnets
 */
public class StatusRequest extends BaseRequest {

    /**
     * 模板Id
     */
    private String tplid;

    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }
}
