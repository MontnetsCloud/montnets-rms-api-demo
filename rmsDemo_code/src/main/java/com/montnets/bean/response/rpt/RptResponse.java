package com.montnets.bean.response.rpt;

import com.montnets.bean.Rpt;
import com.montnets.bean.response.BaseResponse;

import java.util.List;

/**
 * 状态报告响应实体
 *
 * @author montnets
 */
public class RptResponse extends BaseResponse {

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
