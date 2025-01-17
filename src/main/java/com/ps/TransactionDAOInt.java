package com.ps;

import java.util.List;

public interface TransactionDAOInt {

    void addDeposit(Transaction transaction);
    void makePayment(Transaction transaction);
    List<Transaction> displayAll();
    void displayDeposits();
    void displayPayments();
    void displayMonthToDate();
    void displayPreviousMonth();
    void displayYearToDate();
    void displayPreviousYear();
    void searchByVendor(String vendor);
    void searchByCustomSearch();
}
