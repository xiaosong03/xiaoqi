package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 企业职员表(CompStaff)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:00
 */
public class CompStaff implements Serializable {
    private static final long serialVersionUID = 696647941723171276L;
    /**
     * 所属企业id
     */
    private Integer compId;
    /**
     * 工号
     */
    private Integer number;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 职位(1boss2emp)
     */
    private Integer job;


    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

}

