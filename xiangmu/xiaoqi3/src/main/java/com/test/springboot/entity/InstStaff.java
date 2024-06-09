package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 机构职员表(InstStaff)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class InstStaff implements Serializable {
    private static final long serialVersionUID = 772534837343065600L;
    /**
     * 机构职员id
     */
    private Integer id;
    /**
     * 所属机构id
     */
    private Integer instId;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
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

