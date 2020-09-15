package com.montnets.bean.request.callback;

import com.montnets.bean.TplStatus;

import java.util.List;

/**
 * 模板状态回调请求实体
 * @author montnets
 */
public class StatusCallbackRequest extends CallbackRequest {

    /**
     * 模板状态数组
     */
    private List<TplStatus> tplsts;

    public List<TplStatus> getTplsts() {
        return tplsts;
    }

    public void setTplsts(List<TplStatus> tplsts) {
        this.tplsts = tplsts;
    }
}
