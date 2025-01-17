package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAOInt {
    private BasicDataSource dataSource;



    public TransactionDAOImpl(BasicDataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Override
    public void addDeposit(Transaction transaction) {
        // String query = "INSERT INTO transactions(Description, Vendor, Amount, Date, Time) VALUES(?,?,?,?,?)"

    }

    @Override
    public void makePayment(Transaction transaction) {
        //  String query = "INSERT INTO transactions(Description, Vendor, Amount, Date, Time) VALUES(?,?,?,?,?)
    }

    @Override
    public List<Transaction> displayAll() {
        List<Transaction> transactions = new ArrayList<>();
        // add all transactions and then return this list

        String query = "SELECT * FROM transactions;";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String description = resultSet.getString("Description");
                String vendor = resultSet.getString("Vendor");
                double amount = resultSet.getDouble("Amount");
                LocalDate date = resultSet.getDate("Date").toLocalDate();
                LocalTime time = resultSet.getTime("Time").toLocalTime();

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    @Override
    public void displayDeposits() {
        //String query = "SELECT * FROM transaction WHERE Amount > 0";

    }

    @Override
    public void displayPayments() {
        //String query = "SELECT * FROM WHERE Amount < 0"

    }

    @Override
    public void displayMonthToDate() {

    }

    @Override
    public void displayPreviousMonth() {

    }

    @Override
    public void displayYearToDate() {

    }

    @Override
    public void displayPreviousYear() {

    }

    @Override
    public void searchByVendor(String vendor) {

    }

    @Override
    public void searchByCustomSearch() {

    }
}
