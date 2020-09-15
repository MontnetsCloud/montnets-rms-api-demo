package com.montnets.bean.response.tpl;

import com.montnets.bean.Detail;
import com.montnets.bean.response.BaseResponse;

import java.util.List;

/**
 * @author montnets
 */
public class TplManagerResponse extends BaseResponse {

    /**
     * 模板处理结果数组
     */
    private List<Detail> detail;


    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
