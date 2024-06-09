package com.test.springboot.vo;

public class TrainVo {

    private int id;
    private  String instName;
    private  String description;
    private  String name;
    private  int isInCoop;
    private  String isInCoop1;
    private Integer charge;
    private String registerName;
   private  String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getIsInCoop1() {
        return isInCoop1;
    }

    public void setIsInCoop1(String isInCoop1) {
        this.isInCoop1 = isInCoop1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsInCoop() {
        return isInCoop;
    }

    public void setIsInCoop(int isInCoop) {
        this.isInCoop = isInCoop;
    }
}
