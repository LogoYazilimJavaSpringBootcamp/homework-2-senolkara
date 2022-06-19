package com.karakurt.invoices;

import com.karakurt.address.AddressINF;
import com.karakurt.company.CompanyINF;
import com.karakurt.customer.CustomerINF;
import com.karakurt.needs.DateOperations;

import java.time.LocalDate;

public class BuyingInvoice implements InvoiceINF {
    private String invoiceNo;
    private AddressINF address;
    private Double amount;
    private Double averageAmount;
    private CustomerINF customer;
    private CompanyINF company;
    private InvoiceType invoiceType;
    private LocalDate createdDT = DateOperations.createdDT;
    @Override
    public String getInvoiceNo() {
        return invoiceNo;
    }
    @Override
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    @Override
    public LocalDate getCreatedDT() {
        return createdDT;
    }
    @Override
    public void setCreatedDT(LocalDate createdDT) {
        this.createdDT = createdDT;
    }
    @Override
    public AddressINF getAddress() {
        return address;
    }
    @Override
    public void setAddress(AddressINF address) {
        this.address = address;
    }
    @Override
    public Double getAmount() {
        return amount;
    }
    @Override
    public Double getAverageAmount() {
        return averageAmount;
    }
    @Override
    public void setAverageAmount(Double averageAmount) {
        this.averageAmount = averageAmount;
    }
    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Override
    public CustomerINF getCustomer() {
        return customer;
    }
    @Override
    public void setCustomer(CustomerINF customer) {
        this.customer = customer;
    }
    @Override
    public CompanyINF getCompany() {
        return company;
    }
    @Override
    public void setCompany(CompanyINF company) {
        this.company = company;
    }
    @Override
    public InvoiceType getInvoiceType(){
        return invoiceType;
    }
    @Override
    public void setInvoiceType(InvoiceType invoiceType){
        this.invoiceType = invoiceType;
    }
}
