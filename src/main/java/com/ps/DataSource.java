package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.crypto.Data;

public class DataSource {

    public BasicDataSource getDataSource(String username, String password){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Accounting_Ledger");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }



}
