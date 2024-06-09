package com.test.springboot.vo;

public class InstitutionVo {
    private static final long serialVersionUID = -70423503401514764L;
    /**
     * 机构id
     */
    private Integer id;
    /**
     * 机构名
     */
    private String name;
    /**
     * 机构信息
     */
    private String description;
    /**
     * 注册人的用户id
     */
    private Integer registrant;
    private String registrant1;
    /**
     * 新加入员工的员工号
     */
    private Integer lastNum;
    /**
     * 管理员的用户id
     */
    private Integer manager;
    private String manager1;
    private Integer hot;
    private  String registerName;

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getManager1() {
        return manager1;
    }

    public void setManager1(String manager1) {
        this.manager1 = manager1;
    }

    private  int page;
    private  int limit;

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

    public String getRegistrant1() {
        return registrant1;
    }

    public void setRegistrant1(String registrant1) {
        this.registrant1 = registrant1;
    }
}
