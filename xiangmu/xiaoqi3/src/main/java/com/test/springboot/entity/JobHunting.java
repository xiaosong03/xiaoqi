package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 求职信息表(JobHunting)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class JobHunting implements Serializable {
    private static final long serialVersionUID = -58284313100469770L;
    /**
     * 求职信息id
     */
    private Integer id;
    /**
     * 所属用户id
     */
    private Integer userId;
    /**
     * 附带的简历id
     */
    private Integer resuId;
    /**
     * 求职详情
     */
    private String description;

    private String compId;
    private Integer compId1;

    public Integer getCompId1() {
        return compId1;
    }

    public void setCompId1(Integer compId1) {
        this.compId1 = compId1;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResuId() {
        return resuId;
    }

    public void setResuId(Integer resuId) {
        this.resuId = resuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

