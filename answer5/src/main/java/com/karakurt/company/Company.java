package com.karakurt.company;

public class Company implements CompanyINF {
    private String name;
    private String industry;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
