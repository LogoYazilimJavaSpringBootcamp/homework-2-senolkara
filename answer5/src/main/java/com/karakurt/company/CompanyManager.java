package com.karakurt.company;

import java.util.*;

public class CompanyManager {
    private List<CompanyINF> companies;
    public List<CompanyINF> getCompanyList() {
        List<CompanyINF> companyList = new ArrayList<>();
        Map<String,String> randomCompanies = this.getRandomCompanies();
        randomCompanies.forEach((key,value) -> {
            companyList.add(createCompany(key,value));
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
    public CompanyINF createCompany(String name, String industry){
        return CompanyFactory.createCompany(name, industry);
    }
    public CompanyINF getOneCompany(List<CompanyINF> companyList, int randomIndex){
        return companyList.get(randomIndex);
    }
}
