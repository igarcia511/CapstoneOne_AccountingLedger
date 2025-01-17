package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAOImpl implements  TransactionDAOInt{
    private BasicDataSource dataSource;

    public TransactionDAOImpl(BasicDataSource dataSource){
        this.dataSource = dataSource;

    }
    @Override
    public void addDeposit(Transaction transaction) {
        String query = "INSERT INTO transactions(Description, Vendor, Amount, Date, Time) VALUES(?,?,?,?,?);";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query) ){

            preparedStatement.setString(1, transaction.getDescription());
            preparedStatement.setString(2, transaction.getVendor());
            preparedStatement.setDouble(3, transaction.getAmount());

            Date date = new Date(String.valueOf(transaction.getDate()));
            preparedStatement.setDate(4, (java.sql.Date) date);

           // preparedStatement.setTime(5, transaction.getTime());

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);


        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void makePayment(Transaction transaction) {
        String query = "INSERT INTO transactions(Description, Vendor, Amount, Date, Time) VALUES(?,?,?,?,?);";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query) ) {

            preparedStatement.setString(1, transaction.getDescription());
            preparedStatement.setString(2, transaction.getVendor());
            preparedStatement.setDouble(3, transaction.getAmount());

            Date date = new Date(String.valueOf(transaction.getDate()));
            preparedStatement.setDate(4, (java.sql.Date) date);

         //   preparedStatement.setTime(5, transaction.getTime());

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);

        } catch(SQLException e){
            e.printStackTrace();
        }
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

            while(resultSet.next()){
                String description = resultSet.getString("Description");
                String vendor = resultSet.getString("Vendor");
                double amount = resultSet.getDouble("Amount");
                LocalDate date = resultSet.getDate("Date").toLocalDate();
                LocalTime time = resultSet.getTime("Time").toLocalTime();

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);

            }
            return transactions;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Transaction> displayDeposits() {
        String query = "SELECT * FROM transactions WHERE Amount > 0";
          List<Transaction> deposits = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String description = resultSet.getString("Description");
                String vendor = resultSet.getString("Vendor");
                double amount = resultSet.getDouble("Amount");
                LocalDate date = resultSet.getDate("Date").toLocalDate();
                LocalTime time = resultSet.getTime("Time").toLocalTime();

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                deposits.add(transaction);

            }
            return deposits;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Transaction> displayPayments() {
        String query = "SELECT * FROM transactions WHERE Amount < 0;";
        List<Transaction> payments = new ArrayList<>();

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String description = resultSet.getString("Description");
                String vendor = resultSet.getString("Vendor");
                double amount = resultSet.getDouble("Amount");
                LocalDate date = resultSet.getDate("Date").toLocalDate();
                LocalTime time = resultSet.getTime("Time").toLocalTime();

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                payments.add(transaction);

            }

           return payments;

        } catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> displayMonthToDate() {

        return null;
    }

    @Override
    public List<Transaction> displayPreviousMonth() {

        return null;
    }

    @Override
    public List<Transaction> displayYearToDate() {

        return null;
    }

    @Override
    public List<Transaction> displayPreviousYear() {

        return null;
    }

    @Override
    public List<Transaction> searchByVendor(String vendor) {

        return null;
    }

    @Override
    public List<Transaction> searchByCustomSearch() {

        return null;
    }
}
