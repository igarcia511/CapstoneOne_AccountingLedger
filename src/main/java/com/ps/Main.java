package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner commandScanner = new Scanner(System.in);
    static Scanner inputScanner = new Scanner(System.in);
   static  ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        loadTransactions(); // <-- this will load the files as soon as the app is ran, if i dont then option 3 will be empty

        int mainMenuCommand;
        do {
            System.out.println("1) to Add Deposit");
            System.out.println("2) to  Make Payment(debit)");
            System.out.println("3) to Display Ledger");
            System.out.println("0) to exit application");

            System.out.print("Command: ");
            mainMenuCommand = commandScanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    displayLedger();
                    break;
                case 0:
                    System.out.println("Exiting the application. . .");
                    break;
                default:
                    System.out.println("Invalid command try again. . .");
            }

        } while (mainMenuCommand != 0);
    }

    public static void loadTransactions(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String header = bufferedReader.readLine();
            String input;

            while((input = bufferedReader.readLine()) != null){

               // LocalDate date, LocalTime time, String description, String vendor, double amount
                String[] transactionArr = input.split("\\|");
                LocalDate date = LocalDate.parse(transactionArr[0], dateFormatter);
                LocalTime time = LocalTime.parse(transactionArr[1]);
                String description = transactionArr[2];
                String vendor = transactionArr[3];
                double amount = Double.parseDouble(transactionArr[4]);

                 Transaction transaction = new Transaction(date, time, description, vendor, amount);

                 transactions.add(transaction);
            }
            bufferedReader.close();
        } catch(Exception e){

            e.printStackTrace();
        }
    }

    public static void addDeposit() {
        System.out.println("Adding deposit test. . .");
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");


            // prompt user for date
            System.out.print("Enter the date of the payment in yyyy-mm-dd format: ");
            String paymentDate = inputScanner.nextLine();
            LocalDate date = LocalDate.parse(paymentDate, dateFormatter);

            // prompt user for time of payment
            System.out.print("Enter the time of the payments in hh:mm:ss format: ");
            String timeOfPayment = inputScanner.nextLine();
            LocalTime time = LocalTime.parse(timeOfPayment);

            // promt user for transaction description
            System.out.println("Enter the description of transaction: ");
            String description = inputScanner.nextLine();

            System.out.print("Enter the name of the vendor: ");
            String vendorName = inputScanner.nextLine();

            System.out.println("Enter the amount of the transaction: ");
            double transactionAmount = inputScanner.nextDouble();
            inputScanner.nextLine();
            Transaction transaction = new Transaction(date, time, description, vendorName, transactionAmount);
            transactions.add(transaction);



            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
            bufferedWriter.write("\n" + transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());


            bufferedWriter.close();

        } catch(Exception e ){
            System.out.println("invalid command, select an option. . .");
        }
    }

    public static void makePayment() {

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
            System.out.println("make payment test. . .");

            // prompt user for date
            System.out.print("Enter the date of the payment in yyyy-mm-dd format: ");
            String paymentDate = inputScanner.nextLine();
            LocalDate date = LocalDate.parse(paymentDate, dateFormatter);

            // prompt user for time of payment
            System.out.print("Enter the time of the payments in hh:mm:ss format: ");
            String timeOfPayment = inputScanner.nextLine();
            LocalTime time = LocalTime.parse(timeOfPayment);

            // promt user for transaction description
            System.out.println("Enter the description of transaction: ");
            String description = inputScanner.nextLine();

            System.out.print("Enter the name of the vendor: ");
            String vendorName = inputScanner.nextLine();

            System.out.println("Enter the amount of the transaction: ");
            double transactionAmount = inputScanner.nextDouble();
            double amount = -transactionAmount; // turning the amount negative
            inputScanner.nextLine();
            Transaction transaction = new Transaction(date, time, description, vendorName, amount);
            transactions.add(transaction);



                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
                bufferedWriter.write("\n" + transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());


                bufferedWriter.close();

        } catch(Exception e ){
            System.out.println("invalid command, select an option. . .");
        }





    }

    public static void displayLedger() {
        int subMenuCommand;
        do {
            System.out.println("1) to display all");
            System.out.println("2) to display deposits");
            System.out.println("3) to display payments");
            System.out.println("4) to navigate to reports");
            System.out.println("0) to return to main menu");

            System.out.print("Command: ");
            subMenuCommand = commandScanner.nextInt();

            switch (subMenuCommand) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    displayDeposits();
                    break;
                case 3:
                    displayPayments();
                    break;
                case 4:
                    reportsMenu();
                    break;
                case 0:
                    System.out.println("Returning to main menu");
                    break;
                default:
                    System.out.println("Invalid Command. . .");
            }
        } while (subMenuCommand != 0);

    }

    public static void displayAll() {
        // need to display newest entries first To Do
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
        for(int i = 0; i < transactions.size(); i++){

            Transaction t = transactions.get(i);
            System.out.print(t.getDate() + " | " +   t.getTime().format(timeFormat) + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount() + "\n");
        }
        System.out.println("\n");
    }

    public static void displayDeposits() {
        System.out.println("Display deposits testing");
    }

    public static void displayPayments() {
        System.out.println("display payments testing");
    }

    public static void reportsMenu() {

        int reportsMenuCommand;
        do {
            System.out.println("1) for to display Month to Date");
            System.out.println("2) to display previous month transactions");
            System.out.println("3) to display year to date transactions");
            System.out.println("4) to display previous Year transactions");
            System.out.println("5) to search transactions by vendor");

            System.out.print("Command: ");
            reportsMenuCommand = commandScanner.nextInt();

            switch (reportsMenuCommand) {
                case 1:
                    displayMonthToDate();
                    break;
                case 2:
                    displayPreviousMonth();
                    break;
                case 3:
                    displayYearToDate();
                    break;
                case 4:
                    displayPreviousYear();
                    break;
                case 5:
                    searchByVendor();
                    break;
                case 0:
                    System.out.println("Returning to ledger menu");
                    break;
                default:
                    System.out.println("Invalid command. . .");
            }


        } while (reportsMenuCommand != 0);
    }

    public static void displayMonthToDate() {
        System.out.println("Display month test");
    }

    public static void displayPreviousMonth() {
        System.out.println("Display previous month");
    }

    public static void displayYearToDate() {
        System.out.println("Display year to date");
    }

    public static void displayPreviousYear() {
        System.out.println("Display previous year");
    }

    public static void searchByVendor() {
        System.out.println("Display search by vendor");
    }


}