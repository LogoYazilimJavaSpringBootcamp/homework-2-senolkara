package com.karakurt.company;

public class PersonCompany implements CompanyINF {
    private String name;
    private String industry;
    private CompanyType companyType;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getIndustry() {
        return industry;
    }
    @Override
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    @Override
    public CompanyType getCompanyType(){
        return companyType;
    }
    @Override
    public void setCompanyType(CompanyType companyType){
        this.companyType = companyType;
    }
}
