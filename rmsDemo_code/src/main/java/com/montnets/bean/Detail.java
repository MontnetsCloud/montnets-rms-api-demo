package com.montnets.bean;

/**
 * 模板处理结果
 * @author montnets
 */
public class Detail {

    /**
     * 模板 ID
     */
    private String tplid;

    /**
     * 模板处理结果
     */
    private String result;

    /**
     * 模板处理结果描述
     */
    private String desc;


    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
