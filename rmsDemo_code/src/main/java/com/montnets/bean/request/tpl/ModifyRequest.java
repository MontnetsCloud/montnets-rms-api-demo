package com.montnets.bean.request.tpl;


/**
 * 模板修改请求实体
 * @author montnets
 */
public class ModifyRequest extends TplRequest {

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
