package com.montnets.bean;


/**
 * 富信资源实体
 *
 * @author montnets
 */
public class RmsResource {

    /**
     * 帧数序号
     */
    private String index;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源来源
     */
    private String source;

    /**
     * 资源内容
     */
    private String content;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
