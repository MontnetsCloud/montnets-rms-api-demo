package com.montnets.bean.response.send;

import com.montnets.bean.MultiDynamicSendDetail;
import com.montnets.bean.UniDynamicSendDetail;

import java.util.List;

/**
 * @author montnets
 */
public class MultiDynamicSendResponse extends SendResponse {

    private List<MultiDynamicSendDetail> detail;

    public List<MultiDynamicSendDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<MultiDynamicSendDetail> detail) {
        this.detail = detail;
    }
}
