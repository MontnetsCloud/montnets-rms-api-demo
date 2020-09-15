package com.montnets.bean.request.callback;

import com.montnets.bean.request.BaseRequest;

/**
 * 回调请求类
 * @author montnets
 */
public class CallbackRequest extends BaseRequest {

    /**
     * 请求命令字
     */
    private String cmd;

    /**
     * 请求包序号
     */
    private Integer seqid;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

}
