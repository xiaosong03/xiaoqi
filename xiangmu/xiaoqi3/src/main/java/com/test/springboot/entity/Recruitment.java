package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 招聘信息表(Recruitment)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class Recruitment implements Serializable {
    private static final long serialVersionUID = -55584892518138869L;
    /**
     * 招聘信息id
     */
    private Integer id;
    /**
     * 所属的企业id
     */
    private Integer compId;
    /**
     * 招聘详情
     */
    private String description;
private Integer hot;

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

