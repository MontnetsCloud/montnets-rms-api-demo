package com.montnets.bean.response.mo;

import com.montnets.bean.Mo;
import com.montnets.bean.response.BaseResponse;

import java.util.List;

/**
 * 上行消息响应实体
 *
 * @author montnets
 */
public class MoResponse extends BaseResponse {

    /**
     * 上行数组
     */
    private List<Mo> mos;

    public List<Mo> getMos() {
        return mos;
    }

    public void setMos(List<Mo> mos) {
        this.mos = mos;
    }
}
