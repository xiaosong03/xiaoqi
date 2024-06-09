package com.test.springboot.entity;

import java.io.Serializable;

/**
 * 公司企业表(Company)实体类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -24634965600983065L;
    /**
     * 企业id
     */
    private Integer id;
    /**
     * 企业名
     */
    private String name;
    /**
     * 企业信息
     */
    private String description;
    /**
     * 注册人的用户id
     */
    private Integer registrant;
    /**
     * 新加入员工的员工号
     */
    private Integer lastNum;
    /**
     * 管理员的用户id
     */
    private Integer manager;
    private  Integer hot;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRegistrant() {
        return registrant;
    }

    public void setRegistrant(Integer registrant) {
        this.registrant = registrant;
    }

    public Integer getLastNum() {
        return lastNum;
    }

    public void setLastNum(Integer lastNum) {
        this.lastNum = lastNum;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registrant=" + registrant +
                ", lastNum=" + lastNum +
                ", manager=" + manager +
                '}';
    }
}

