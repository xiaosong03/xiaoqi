package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 用户_培训计划表(UserTraining)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public class UserTraining implements Serializable {
    private static final long serialVersionUID = 575865721564002707L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 培训计划id
     */
    private Integer trainingId;


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

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

}

