package com.github.DiamondPRO02.repository;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Builder
@Slf4j
public class DatabaseConnecftion {
    private final String driver;
    private final String databaseUrl;
}
