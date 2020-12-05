package com.github.DiamondPRO02.config;

import com.github.DiamondPRO02.repository.DatabaseConnecftion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Bean
    public DatabaseConnecftion databaseConnecftion(){
        return DatabaseConnecftion.builder()
                .driver(driver)
                .databaseUrl(url)
                .build();
    }
}
