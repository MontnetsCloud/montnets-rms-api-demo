package com.montnets.bean.request.callback;

import com.montnets.bean.Rpt;

import java.util.List;

/**
 * 状态报告回调请求实体
 * @author montnets
 */
public class RptCallbackRequest extends CallbackRequest {

    /**
     * 状态报告数组
     */
    private List<Rpt> rpts;

    public List<Rpt> getRpts() {
        return rpts;
    }

    public void setRpts(List<Rpt> rpts) {
        this.rpts = rpts;
    }
}
