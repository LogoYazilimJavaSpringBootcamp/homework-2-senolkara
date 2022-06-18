package com.karakurt;

import com.karakurt.invoices.InvoiceINF;
import com.karakurt.invoices.InvoiceManager;
import com.karakurt.needs.DateOperations;
import com.karakurt.user.UserManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main( String[] args ) {

        final LocalDate startDate = DateOperations.startDate;
        final LocalDate endDate = DateOperations.endDate;

        System.out.println("Yeni müşteri oluştur");
        System.out.println("----------------------------");
        Scanner inputFirstName = new Scanner(System.in);
        System.out.print("Müşteri Adını giriniz: ");
        String firstName = inputFirstName.nextLine();
        Scanner inputLastName = new Scanner(System.in);
        System.out.print("Müşteri Soyadını giriniz: ");
        String lastName = inputLastName.nextLine();
        Scanner inputAddress = new Scanner(System.in);
        System.out.print("Müşteri Adresini giriniz: ");
        String address = inputAddress.nextLine();
        System.out.println("----------------------------");
        System.out.println();

        UserManager userManager = new UserManager();
        Map<String,String> randomUserList = userManager.addUser(firstName,lastName,address);
        userManager.setRandomUsers(randomUserList);

        InvoiceManager invoiceManager = new InvoiceManager();

        System.out.println("Tüm müşteriler");
        System.out.println("----------------------------");
        List<String> customerList = invoiceManager.getInvoiceList().stream()
                .map(invoice -> invoice.getCustomer())
                .map(customer -> customer.getFirstName() + " " + customer.getLastName())
                .toList();
        customerList.forEach(System.out::println);
        System.out.println("----------------------------");
        System.out.println();

        System.out.println("İçerisinde C harfi geçen müşteriler List örneği");
        System.out.println("-----------------------------------------------");
        List<String> customerContainsC = invoiceManager.getInvoiceList().stream()
                .map(invoice -> invoice.getCustomer())
                .map(customer -> customer.getFirstName() + " " + customer.getLastName())
                .filter(customerName -> customerName.contains("C")).toList();
        customerContainsC.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println();

        System.out.println("İçerisinde C harfi geçen müşteriler Set örneği");
        System.out.println("-----------------------------------------------");
        Set<String> customerSet = invoiceManager.getInvoiceList().stream()
                .map(invoice -> invoice.getCustomer())
                .map(customer -> customer.getFirstName() + " " + customer.getLastName())
                .filter(customerName -> customerName.contains("C"))
                .collect(Collectors.toSet());
        customerSet.forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        System.out.println();

        System.out.println("Haziran ayında kayıt olan müşteri faturalarının toplam tutarları");
        System.out.println("----------------------------------------------------------------");
        List<InvoiceINF> invoiceList1 = invoiceManager.getInvoiceList().stream()
                .filter(invoice -> invoice.getCreatedDT().isAfter(startDate) && invoice.getCreatedDT().isBefore(endDate))
                .toList();
        System.out.println(invoiceList1.stream().map(InvoiceINF::getAmount).reduce(0.0,Double::sum));
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        System.out.println("Sistemdeki tüm faturalar");
        System.out.println("----------------------------------------------------------------");
        List<String> allInvoices = invoiceManager.getInvoiceList().stream()
                .map(invoice -> "Fatura No: " + invoice.getInvoiceNo() + " \t Adres: " + invoice.getAddress().getAddress() + " \t Fatura Tutarı: " + invoice.getAmount() + " \t Tarih: " + invoice.getCreatedDT())
                .toList();
        allInvoices.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        System.out.println("Sistemdeki 1500TL üstündeki faturalar");
        System.out.println("-------------------------------------");
        List<String> greaterThan1500Invoices = invoiceManager.getInvoiceList().stream()
                .filter(invoice -> invoice.getAmount() > 1500.00)
                .map(invoice -> "Fatura No: " + invoice.getInvoiceNo() + " \t Adres: " + invoice.getAddress().getAddress() + " \t Fatura Tutarı: " + invoice.getAmount() + " \t Tarih: " + invoice.getCreatedDT())
                .toList();
        greaterThan1500Invoices.forEach(System.out::println);
        System.out.println("-------------------------------------");
        System.out.println();

        System.out.println("-------------------------------------");
        double greaterThan1500InvoicesAvg = invoiceManager.getInvoiceList().stream()
                .filter(invoice -> invoice.getAmount() > 1500.00)
                .mapToDouble(InvoiceINF::getAmount)
                .average()
                .getAsDouble();
        System.out.println("Sistemdeki 1500TL üstündeki faturaların ortalaması: " + greaterThan1500InvoicesAvg);
        System.out.println("-------------------------------------");
        System.out.println();

        System.out.println("Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri");
        System.out.println("-----------------------------------------------------------------");
        List<String> customersWithInvoicesUnder500 = invoiceManager.getInvoiceList().stream()
                .filter(invoice -> invoice.getAmount() < 500.00)
                .map(invoice -> invoice.getCustomer().getFirstName() + " " + invoice.getCustomer().getLastName())
                .toList();
        customersWithInvoicesUnder500.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        System.out.println("Haziran ayı faturalarının ortalaması 750 altı olan firmaların sektörleri");
        System.out.println("----------------------------------------------------------------");
        List<String> lessThan750InvoicesAvgInJuneReturnCompany = invoiceManager.getInvoiceList().stream()
                .filter(invoice -> invoice.getAverageAmount() < 750.00)
                .map(invoice -> invoice.getCompany().getIndustry())
                .toList();
        lessThan750InvoicesAvgInJuneReturnCompany.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }
}
