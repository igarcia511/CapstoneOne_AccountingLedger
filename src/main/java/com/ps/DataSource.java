package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.crypto.Data;

public class DataSource {

    public BasicDataSource getDataSource(){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Accounting_Ledger");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");

        return dataSource;
    }



}
