package com.montnets.bean.request.send;

import java.util.Map;

/**
 * 文本动参请求实体
 * @author montnets
 */
public class TxtDynamicSendRequest extends SendRequest {

    /**
     * 发送内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
