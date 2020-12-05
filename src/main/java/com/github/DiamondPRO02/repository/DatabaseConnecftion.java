package com.github.DiamondPRO02.repository;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RequiredArgsConstructor
@Builder
@Slf4j
public class DatabaseConnecftion {
    private final String driver;
    private final String databaseUrl;
    private final String dataBaseUsername;
    private final String dataBasePassword;

    public <T> T query(String sql, Mapper<T> mapper){
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(databaseUrl, dataBaseUsername, dataBasePassword);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            T result = mapper.map(resultSet);

            statement.close();
            connection.close();

            return result;
        }catch (Exception e) {
            throw new RuntimeException("Database query failed", e);
        }
    }

    public void execute(String sql) {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(databaseUrl, dataBaseUsername, dataBasePassword);
            Statement statement = connection.createStatement();

            statement.execute(sql);

            statement.close();
            connection.close();
        }catch (Exception e) {
            throw new RuntimeException("Database query failed", e);
        }
    }
}
