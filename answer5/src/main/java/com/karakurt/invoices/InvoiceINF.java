package com.karakurt.invoices;

import com.karakurt.address.AddressINF;
import com.karakurt.company.CompanyINF;
import com.karakurt.customer.CustomerINF;
import com.karakurt.needs.DateOperations;

public interface InvoiceINF extends DateOperations {
    String getInvoiceNo();
    void setInvoiceNo(String invoiceNo);
    AddressINF getAddress();
    void setAddress(AddressINF address);
    Double getAmount();
    Double getAverageAmount();
    void setAverageAmount(Double averageAmount);
    void setAmount(Double amount);
    CustomerINF getCustomer();
    void setCustomer(CustomerINF customer);
    CompanyINF getCompany();
    void setCompany(CompanyINF company);
    InvoiceType getInvoiceType();
    void setInvoiceType(InvoiceType invoiceType);
}
