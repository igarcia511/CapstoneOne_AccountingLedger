package com.ps;

import java.util.Scanner;

public class Main {

    static Scanner commandScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // loadLedgerFile(); <-- this will load the files as soon as the app is ran, if i dont then option 3 will be empty

        int mainMenuCommand;
        do{
            System.out.println("1) to Add Deposit");
            System.out.println("2) to  Make Payment(debit)");
            System.out.println("3) to Display Ledger");
            System.out.println("Command: ");
            mainMenuCommand = commandScanner.nextInt();

            switch(mainMenuCommand){
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

        }while(mainMenuCommand != 0);
    }

    public static void addDeposit(){
        System.out.println("Adding deposit test. . .");
    }

    public static void makePayment(){
        System.out.println("make payment test. . .");
    }

    public static void displayLedger(){
        System.out.println("display ledger test. . .");
    }
}