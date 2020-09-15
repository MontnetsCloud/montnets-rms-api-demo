package com.montnets.bean.request.send;

/**
 * 通用动参请求实体
 * @author montnets
 */
public class UniDynamicSendRequest extends SendRequest {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
