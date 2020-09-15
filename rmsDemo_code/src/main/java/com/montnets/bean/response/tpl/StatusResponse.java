package com.montnets.bean.response.tpl;

import com.montnets.bean.TplStatus;
import com.montnets.bean.response.BaseResponse;

import java.util.List;

/**
 * @author montnets
 */
public class StatusResponse extends BaseResponse {

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
