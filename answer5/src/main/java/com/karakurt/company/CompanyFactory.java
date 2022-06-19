package com.karakurt.company;

public class CompanyFactory {
    public static CompanyINF createCompany(String name, String industry, CompanyType companyType){
        CompanyINF company;
        switch (companyType){
            case PERSON -> {
                company = new PersonCompany();
            }
            case CORPORATE -> {
                company = new CorporateCompany();
            }
            case STARTUP -> {
                company = new StartUpCompany();
            }
            default -> {
                throw new RuntimeException("CompanyType not found");
            }
        }
        company.setName(name);
        company.setIndustry(industry);
        company.setCompanyType(companyType);
        return company;
    }
}
