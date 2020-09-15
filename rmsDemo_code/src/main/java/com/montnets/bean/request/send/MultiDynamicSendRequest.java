package com.montnets.bean.request.send;

import java.util.List;
import java.util.Map;

/**
 * 个性化动参请求实体
 * @author montnets
 */
public class MultiDynamicSendRequest extends SendRequest {

    /**
     * 个性化信息详情
     */
    private List<Map<String, Object>> multimt;

    public List<Map<String, Object>> getMultimt() {
        return multimt;
    }

    public void setMultimt(List<Map<String, Object>> multimt) {
        this.multimt = multimt;
    }
}
