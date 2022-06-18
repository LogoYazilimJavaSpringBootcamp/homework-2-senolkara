package com.karakurt.company;

public class CompanyFactory {
    public static CompanyINF createCompany(String name, String industry){
        CompanyINF company = new Company();
        company.setName(name);
        company.setIndustry(industry);
        return company;
    }
}
