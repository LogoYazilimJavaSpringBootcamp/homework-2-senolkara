package com.karakurt.invoices;

import com.karakurt.address.Address;
import com.karakurt.address.AddressINF;
import com.karakurt.address.AddressType;
import com.karakurt.company.CompanyINF;
import com.karakurt.company.CompanyManager;
import com.karakurt.customer.CustomerINF;
import com.karakurt.customer.CustomerManager;
import com.karakurt.order.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InvoiceManager {
    private List<InvoiceINF> invoices;
    public List<InvoiceINF> getInvoiceList() {
        List<InvoiceINF> invoiceList = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();
        List<CustomerINF> customerList = customerManager.getCustomerList();
        customerList.forEach(customer -> {
            OrderINF order = customer.getOrder();
            AddressINF address = this.getBillingAddress(customer.getAddresses());
            Double totalAmount = this.getTotalAmount(order);
            Double averageAmount = this.getAverageAmount(order);

            CompanyManager companyManager = new CompanyManager();
            List<CompanyINF> companyList = companyManager.getCompanyList();
            int randomIndex = new Random().nextInt(companyList.size() - 1);
            String companyName = companyManager.getOneCompany(companyList,randomIndex).getName();
            String companyIndustry = companyManager.getOneCompany(companyList,randomIndex).getIndustry();
            CompanyINF company = companyManager.createCompany(companyName, companyIndustry);

            String invoiceNo = "000" + randomIndex + "000";
            InvoiceINF invoice = this.createInvoice(invoiceNo, order.getCreatedDT(), address, totalAmount, averageAmount, customer, company);
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
                                  CompanyINF company){
        return InvoiceFactory.createInvoice(invoiceNo, createdDT, address, totalAmount, averageAmount, customer, company);
    }
    private AddressINF getBillingAddress(Set<AddressINF> addressSet){
        return addressSet.stream()
                .filter(address -> address.getAddressType() == AddressType.BILLING)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Address type not found"));
    }
    private Double getTotalAmount(OrderINF order){
        return order.getProductList()
                .stream()
                .map(product -> product.getPrice())
                .reduce(0.0,Double::sum);
    }
    private Double getAverageAmount(OrderINF order){
        return getTotalAmount(order) / countOrder(order);
    }
    private Long countOrder(OrderINF order){
        return order.getProductList()
                .stream()
                .map(product -> product.getPrice())
                .count();
    }
}
