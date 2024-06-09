package com.test.springboot.vo;

public class CooperateInfo {
    private String description;
    private String  name;
    private int instCharge;
    private int compStaffIdCharge;
    private String instaffname;

    public String getInstaffname() {
        return instaffname;
    }
    private String compname;

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public void setInstaffname(String instaffname) {
        this.instaffname = instaffname;
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

    public int getInstCharge() {
        return instCharge;
    }

    public void setInstCharge(int instCharge) {
        this.instCharge = instCharge;
    }

    public int getCompStaffIdCharge() {
        return compStaffIdCharge;
    }

    public void setCompStaffIdCharge(int compStaffIdCharge) {
        this.compStaffIdCharge = compStaffIdCharge;
    }

    @Override
    public String toString() {
        return "CooperateInfo{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", instCharge=" + instCharge +
                ", compStaffIdCharge=" + compStaffIdCharge +
                '}';
    }
}
