package com.montnets.bean.request.tpl;

import com.montnets.bean.request.BaseRequest;

/**
 * @author montnets
 */
public class TplManagerRequest extends BaseRequest {

    /**
     * 模板Id
     */
    private String tplid;

    /**
     * 操作类型
     */
    private String optype;

    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }

    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }
}
