package com.montnets.bean;


/**
 * 图片动参资源实体
 *
 * @author montnets
 */
public class DynamicResource {

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源来源
     */
    private String source;

    /**
     * 资源内容
     */
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
