package com.montnets.bean.response;


/**
 * 响应对象
 *
 * @author montnets
 */
public abstract class BaseResponse {

    /**
     * 请求处理结果
     */
    protected Integer result;

    /**
     * 处理结果描述
     */
    protected String desc;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
