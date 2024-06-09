package com.test.springboot.vo;

public class TrainingVo {
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
  private  String registerName;

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    private  int page;
    private  int limit;

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
