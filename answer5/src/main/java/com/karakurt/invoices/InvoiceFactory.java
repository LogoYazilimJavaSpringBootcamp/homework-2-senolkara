package com.karakurt.invoices;

import com.karakurt.address.AddressINF;
import com.karakurt.company.CompanyINF;
import com.karakurt.customer.CustomerINF;

import java.time.LocalDate;

public class InvoiceFactory {
    public static InvoiceINF createInvoice(String invoiceNo,
                                           LocalDate createdDT,
                                           AddressINF address,
                                           Double totalAmount,
                                           Double averageAmount,
                                           CustomerINF customer,
                                           CompanyINF company,
                                           InvoiceType invoiceType){
        InvoiceINF invoice;
        switch (invoiceType){
            case BUYING -> {
                invoice = new BuyingInvoice();
            }
            case SELLING -> {
                invoice = new SellingInvoice();
            }
            default -> {
                throw new RuntimeException("InvoiceType not found");
            }
        }
        invoice.setInvoiceNo(invoiceNo);
        invoice.setCreatedDT(createdDT);
        invoice.setAddress(address);
        invoice.setAmount(totalAmount);
        invoice.setCustomer(customer);
        invoice.setCompany(company);
        invoice.setAverageAmount(averageAmount);
        invoice.setInvoiceType(invoiceType);
        return invoice;
    }
}
