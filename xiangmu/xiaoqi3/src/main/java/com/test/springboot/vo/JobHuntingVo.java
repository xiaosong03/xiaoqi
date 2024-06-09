package com.test.springboot.vo;

public class JobHuntingVo {
    private static final long serialVersionUID = -58284313100469770L;
    /**
     * 求职信息id
     */
    private Integer id;
    /**
     * 所属用户id
     */
    private Integer userId;
    /**
     * 附带的简历id
     */
    private Integer resuId;
    /**
     * 求职详情
     */
    private String description;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private  int page;
    private  int limit;

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

    public Integer getResuId() {
        return resuId;
    }

    public void setResuId(Integer resuId) {
        this.resuId = resuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
