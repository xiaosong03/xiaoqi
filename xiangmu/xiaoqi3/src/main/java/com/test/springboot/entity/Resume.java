package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 简历表(Resume)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public class Resume implements Serializable {
    private static final long serialVersionUID = -60024394968250580L;
    /**
     * 简历id
     */
    private Integer id;
    /**
     * 所属用户id
     */
    private Integer userId;
    /**
     * 简历信息
     */
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}

