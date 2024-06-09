package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 校企合作表(Cooperation)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class Cooperation implements Serializable {
    private static final long serialVersionUID = -62609612065844534L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 合作相关
     */
    private String description;
    /**
     * 培训计划id
     */
    private Integer trainingId;
    /**
     * 机构方负责人(机构职员id)
     */
    private Integer instCharge;
    /**
     * 企业方负责人(企业id)
     */
    private Integer compStaffIdCharge;
    /**
     * 企业方负责人(工号)
     */
    private Integer compStaffNumberCharge;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Integer getInstCharge() {
        return instCharge;
    }

    public void setInstCharge(Integer instCharge) {
        this.instCharge = instCharge;
    }

    public Integer getCompStaffIdCharge() {
        return compStaffIdCharge;
    }

    public void setCompStaffIdCharge(Integer compStaffIdCharge) {
        this.compStaffIdCharge = compStaffIdCharge;
    }

    public Integer getCompStaffNumberCharge() {
        return compStaffNumberCharge;
    }

    public void setCompStaffNumberCharge(Integer compStaffNumberCharge) {
        this.compStaffNumberCharge = compStaffNumberCharge;
    }

}

