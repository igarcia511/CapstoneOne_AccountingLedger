package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);
    int input = Integer.parseInt(inputScanner.nextLine());
    {

        switch (input) {

            case 1 -> Userinterface.addDeposit();
            case 2 -> Userinterface.makePayment();
            case 3 -> Userinterface.displayLedger();
            case 4 -> Userinterface.searchByVendor();
            case 5 -> Userinterface.customSearch();
            case 6 -> Userinterface.reportsMenu();
            case 0 -> {
                {
                    System.out.println("Exiting the application. . .");
                }
                System.exit(0);

            }
        }

    }
}


