package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 机构职员_培训计划表(InstStaffTraining)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class InstStaffTraining implements Serializable {
    private static final long serialVersionUID = -28306779722872404L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 机构职员id
     */
    private Integer instStaffId;
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

    public Integer getInstStaffId() {
        return instStaffId;
    }

    public void setInstStaffId(Integer instStaffId) {
        this.instStaffId = instStaffId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

}

