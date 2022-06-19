package com.karakurt.invoices;

import com.karakurt.address.AddressINF;
import com.karakurt.company.CompanyINF;
import com.karakurt.company.CompanyManager;
import com.karakurt.customer.CustomerINF;
import com.karakurt.customer.CustomerManager;
import com.karakurt.company.CompanyType;
import com.karakurt.order.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceManager {
    private List<InvoiceINF> invoices;
    public List<InvoiceINF> getInvoiceList() {
        List<InvoiceINF> invoiceList = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();
        List<CustomerINF> customerList = customerManager.getCustomerList();
        customerList.forEach(customer -> {
            OrderINF order = customer.getOrder();
            AddressINF address = customer.getAddress();
            Double totalAmount = OrderManager.getTotalAmount(order);
            Double averageAmount = OrderManager.getAverageAmount(order);

            CompanyManager companyManager = new CompanyManager();
            List<CompanyINF> companyList = companyManager.getCompanyList();
            int randomIndex = new Random().nextInt(companyList.size() - 1);
            String companyName = companyManager.getOneCompany(companyList,randomIndex).getName();
            String companyIndustry = companyManager.getOneCompany(companyList,randomIndex).getIndustry();
            CompanyType companyType = companyManager.getOneCompanyType();
            CompanyINF company = companyManager.createCompany(companyName, companyIndustry,companyType);

            String invoiceNo = "000" + randomIndex + "000";
            InvoiceINF invoice = this.createInvoice(invoiceNo, order.getCreatedDT(), address, totalAmount, averageAmount, customer, company, getOneInvoiceType());
            invoiceList.add(invoice);
        });
        this.invoices = invoiceList;
        return this.invoices;
    }
    private InvoiceINF createInvoice(String invoiceNo,
                                  LocalDate createdDT,
                                  AddressINF address,
                                  Double totalAmount,
                                  Double averageAmount,
                                  CustomerINF customer,
                                  CompanyINF company,
                                  InvoiceType invoiceType){
        return InvoiceFactory.createInvoice(invoiceNo,
                createdDT,
                address,
                totalAmount,
                averageAmount,
                customer,
                company,
                invoiceType);
    }
    private List<InvoiceType> getInvoiceTypes(){
        List<InvoiceType> invoiceTypeList = new ArrayList<>();
        for (InvoiceType e: InvoiceType.values()){
            invoiceTypeList.add(e);
        }
        return invoiceTypeList;
    }
    public InvoiceType getOneInvoiceType(){
        long count = this.getInvoiceTypes().stream().count();
        int index = new Random().nextInt((int) count);
        return this.getInvoiceTypes().get(index);
    }
}
