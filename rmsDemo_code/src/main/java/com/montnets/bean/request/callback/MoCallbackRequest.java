package com.montnets.bean.request.callback;

import com.montnets.bean.Mo;

import java.util.List;

/**
 * 上行信息回调请求实体
 * @author montnets
 */
public class MoCallbackRequest extends CallbackRequest {

    /**
     * 上行信息数组
     */
    private List<Mo> mos;

    public List<Mo> getMos() {
        return mos;
    }

    public void setMos(List<Mo> mos) {
        this.mos = mos;
    }
}
