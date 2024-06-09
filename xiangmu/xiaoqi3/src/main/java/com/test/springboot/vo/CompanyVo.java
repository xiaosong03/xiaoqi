package com.test.springboot.vo;

public class CompanyVo {
    private static final long serialVersionUID = -24634965600983065L;


    private String selctName;
    private String selectNu;
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
    private String manager1;
  private  Integer hot;
   private String registerName;

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

    private int limit;
    private  int page;

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

    public String getSelctName() {
        return selctName;
    }

    public void setSelctName(String selctName) {
        this.selctName = selctName;
    }

    public String getSelectNu() {
        return selectNu;
    }

    public void setSelectNu(String selectNu) {
        this.selectNu = selectNu;
    }

    @Override
    public String toString() {
        return "CompanyVo{" +
                "selctName='" + selctName + '\'' +
                ", selectNu='" + selectNu + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registrant=" + registrant +
                ", lastNum=" + lastNum +
                ", manager=" + manager +
                ", limit=" + limit +
                ", page=" + page +
                '}';
    }
}
