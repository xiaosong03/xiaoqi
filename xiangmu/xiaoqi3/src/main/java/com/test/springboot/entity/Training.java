package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 培训计划表(Training)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public class Training implements Serializable {
    private static final long serialVersionUID = -37191758247075284L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 培训相关
     */
    private String description;
    /**
     * 所属机构id
     */
    private Integer instId;
    /**
     * 负责人的机构职员id
     */
    private Integer charge;
    /**
     * 是否属于校企合作
     */
    private Integer isInCoop;
     private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getIsInCoop() {
        return isInCoop;
    }

    public void setIsInCoop(Integer isInCoop) {
        this.isInCoop = isInCoop;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", instId=" + instId +
                ", charge=" + charge +
                ", isInCoop=" + isInCoop +
                '}';
    }
}

