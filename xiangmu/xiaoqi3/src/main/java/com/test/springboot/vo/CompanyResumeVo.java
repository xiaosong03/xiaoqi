package com.test.springboot.vo;

public class CompanyResumeVo {
    private String nickname;
    private String phone;
    private int userId;
    private String id;//jobhunting id
    private String description;//resume

    private int compId;

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CompanyResumeVo{" +
                "nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", compId=" + compId +
                '}';
    }
}