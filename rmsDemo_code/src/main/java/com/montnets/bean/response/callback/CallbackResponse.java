package com.montnets.bean.response.callback;

import com.montnets.bean.response.BaseResponse;

/**
 * 回调响应类
 *
 * @author montnets
 */
public class CallbackResponse extends BaseResponse {

    /**
     * 回应命令字
     */
    private String cmd;

    /**
     * 回应包序号
     */
    private Integer seqId;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }
}
