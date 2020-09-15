package com.montnets.bean;


import java.util.List;

/**
 * 模板状态
 *
 * @author montnets
 */
public class TplStatus {

    /**
     * 自定义流水号
     */
    private String custid;

    /**
     * 模板 id
     */
    private String tplid;

    /**
     * 模板大小
     */
    private Integer tplsize;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 富信档位
     */
    private Integer chgrade;

    /**
     * 模板截止有效日期
     */
    private Integer validtime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 状态描述
     */
    private String desc;

    /**
     * 模板状态详情
     */
    private List<TplStatusDetail> statusdetail;

    /**
     * 模板预览地址
     */
    private String previewurl;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 富信主题
     */
    private String title;

    /**
     * 模板签名
     */
    private String tplsign;

    /**
     * 模板创建时间
     */
    private String createtime;

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTplsign() {
        return tplsign;
    }

    public void setTplsign(String tplsign) {
        this.tplsign = tplsign;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getTplid() {
        return tplid;
    }

    public void setTplid(String tplid) {
        this.tplid = tplid;
    }

    public Integer getTplsize() {
        return tplsize;
    }

    public void setTplsize(Integer tplsize) {
        this.tplsize = tplsize;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getChgrade() {
        return chgrade;
    }

    public void setChgrade(Integer chgrade) {
        this.chgrade = chgrade;
    }

    public Integer getValidtime() {
        return validtime;
    }

    public void setValidtime(Integer validtime) {
        this.validtime = validtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<TplStatusDetail> getStatusdetail() {
        return statusdetail;
    }

    public void setStatusdetail(List<TplStatusDetail> statusdetail) {
        this.statusdetail = statusdetail;
    }
}
