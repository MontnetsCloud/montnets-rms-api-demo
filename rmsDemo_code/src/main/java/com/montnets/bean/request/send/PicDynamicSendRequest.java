package com.montnets.bean.request.send;

/**
 * 图片动参请求实体
 * @author montnets
 */
public class PicDynamicSendRequest extends SendRequest {


    /**
     * 目前接收是 JSON 字符串, 所以这里不是对象
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
