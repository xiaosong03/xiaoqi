package com.test.springboot.entity;

import java.io.Serializable;

/**
 * (ResumeJuti)实体类
 *
 * @author makejava
 * @since 2024-06-03 10:23:07
 */
public class ResumeJuti implements Serializable {
    private static final long serialVersionUID = -43555212257817425L;
    
    private Integer resId;
    
    private String phone;
    
    private String resumeFor;
    
    private String description;
    
    private String selfAbility;
    
    private String education;
    
    private String project;


    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResumeFor() {
        return resumeFor;
    }

    public void setResumeFor(String resumeFor) {
        this.resumeFor = resumeFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelfAbility() {
        return selfAbility;
    }

    public void setSelfAbility(String selfAbility) {
        this.selfAbility = selfAbility;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

}

