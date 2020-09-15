package com.montnets.bean.request.rpt;

import com.montnets.bean.request.BaseRequest;

/**
 * 状态报告请求类
 * @author montnets
 */
public class RptRequest extends BaseRequest {

    /**
     * 每次想要获取的最大条数, 最大为 500
     */
    private Integer retsize;

    public Integer getRetsize() {
        return retsize;
    }

    public void setRetsize(Integer retsize) {
        this.retsize = retsize;
    }
}
