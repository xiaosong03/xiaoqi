package com.test.springboot.vo;

public class InstStaffVo {
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
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 职位(1boss2emp)
     */
    private Integer job1;
    private  String job;

    public Integer getJob1() {
        return job1;
    }

    public void setJob1(Integer job1) {
        this.job1 = job1;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private  int limit;
    private  int page;

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



    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "InstStaffVo{" +
                "id=" + id +
                ", instId=" + instId +
                ", number=" + number +
                ", userId=" + userId +

                ", limit=" + limit +
                ", page=" + page +
                '}';
    }
}
