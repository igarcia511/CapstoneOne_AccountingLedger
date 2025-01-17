package com.ps;

import java.util.List;

public interface TransactionDAOInt {

    void addDeposit(Transaction transaction);
    void makePayment(Transaction transaction);
    List<Transaction> displayAll();
    List<Transaction> displayDeposits();
    List<Transaction> displayPayments();
    List<Transaction> displayMonthToDate();
    List<Transaction> displayPreviousMonth();
    List<Transaction> displayYearToDate();
    List<Transaction> displayPreviousYear();
    List<Transaction> searchByVendor(String vendor);
    List<Transaction> searchByCustomSearch();
}
