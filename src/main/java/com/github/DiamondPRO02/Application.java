package com.github.DiamondPRO02;

import org.apache.commons.lang3.StringUtils;

public class Application {
    public static void main(String[] args) {
        boolean result = StringUtils.isNotBlank("afe");
        System.out.println("Eredmény: " + result);
    }
}
