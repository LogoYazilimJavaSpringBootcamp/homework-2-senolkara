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
                                           CompanyINF company){
        InvoiceINF invoice = new Invoice();
        invoice.setInvoiceNo(invoiceNo);
        invoice.setCreatedDT(createdDT);
        invoice.setAddress(address);
        invoice.setAmount(totalAmount);
        invoice.setCustomer(customer);
        invoice.setCompany(company);
        invoice.setAverageAmount(averageAmount);
        return invoice;
    }
}
