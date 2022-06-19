package com.karakurt.company;

import java.util.*;

public class CompanyManager {
    private List<CompanyINF> companies;
    public List<CompanyINF> getCompanyList() {
        List<CompanyINF> companyList = new ArrayList<>();
        Map<String,String> randomCompanies = this.getRandomCompanies();
        randomCompanies.forEach((key,value) -> {
            companyList.add(createCompany(key,value,getOneCompanyType()));
        });
        this.companies = companyList;
        return this.companies;
    }
    private Map<String,String> getRandomCompanies(){
        Map<String,String> randomCompanies = new HashMap<>();
        randomCompanies.put("Jeans Textile","Textile");
        randomCompanies.put("Jacket Textile","Textile");
        randomCompanies.put("Poncho Textile","Textile");
        randomCompanies.put("Cravat Textile","Textile");
        randomCompanies.put("Belt Textile","Textile");
        randomCompanies.put("Cheesecake Food","Food");
        randomCompanies.put("Burritos Food","Food");
        randomCompanies.put("Sandwich Food","Food");
        randomCompanies.put("Calzone Food","Food");
        randomCompanies.put("Chicken Food","Food");
        randomCompanies.put("Asus Tech","Tech");
        randomCompanies.put("Lenovo Tech","Tech");
        randomCompanies.put("Iphone Tech","Tech");
        randomCompanies.put("Samsung Tech","Tech");
        randomCompanies.put("Casper Tech","Tech");
        return randomCompanies;
    }
    public CompanyINF createCompany(String name, String industry, CompanyType companyEnum){
        return CompanyFactory.createCompany(name, industry, companyEnum);
    }
    public CompanyINF getOneCompany(List<CompanyINF> companyList, int randomIndex){
        return companyList.get(randomIndex);
    }
    private List<CompanyType> getCompanyTypes(){
        List<CompanyType> companyTypeList = new ArrayList<>();
        for (CompanyType e: CompanyType.values()){
            companyTypeList.add(e);
        }
        return companyTypeList;
    }
    public CompanyType getOneCompanyType(){
        long count = this.getCompanyTypes().stream().count();
        int index = new Random().nextInt((int) count);
        return this.getCompanyTypes().get(index);
    }
}
