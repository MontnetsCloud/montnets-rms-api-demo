package com.montnets.bean.response.send;

import com.montnets.bean.response.BaseResponse;

/**
 * 同 request 是一样的
 * 响应结果
 * @author montnets
 */
public class SendResponse extends BaseResponse {

    /**
     * 消息流水号
     */
    private Long msgid;

    /**
     * 自定义流水号
     */
    private String custid;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }
}
