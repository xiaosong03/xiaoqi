package com.test.springboot.vo;

public class RecuitmentVo {
    private static final long serialVersionUID = -55584892518138869L;
    /**
     * 招聘信息id
     */
    private int id;
    /**
     * 所属的企业id
     */
    private Integer compId;
    /**
     * 招聘详情
     */
    private String description;
    private  int page;
    private  int limit;
    private int total;
    private String name;
    private Integer hot;

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RecuitmentVo{" +
                "id=" + id +
                ", compId=" + compId +
                ", description='" + description + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                ", total=" + total +
                '}';
    }
}
