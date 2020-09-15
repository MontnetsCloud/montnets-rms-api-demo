package com.montnets.bean.response.send;

import com.montnets.bean.UniDynamicSendDetail;

import java.util.List;

/**
 * @author montnets
 */
public class PreviewSendResponse extends SendResponse {

    private List<UniDynamicSendDetail> detail;

    public List<UniDynamicSendDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<UniDynamicSendDetail> detail) {
        this.detail = detail;
    }
}
