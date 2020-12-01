package com.github.DiamondPRO02.dependencies;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessLogic {
    private final Provider provider;
    private final Consumer consumer;

    public void process(String param){
        String item = provider.get(param);
        consumer.consume(item);
    }
}
