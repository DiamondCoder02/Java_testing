package com.github.DiamondPRO02.dependencies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class BusinessLogicTest {
    private static final String ITEM = "item";
    private static final String PARAM = "param";

    private Provider provider;
    private Consumer consumer;

    private BusinessLogic underTest;

    @Before
    public void setUp(){
        provider = Mockito.mock(Provider.class);
        consumer = Mockito.mock(Consumer.class);
        underTest = new BusinessLogic(provider, consumer);
    }

    @Test
    public void process(){
        //Given
        given(provider.get(PARAM)).willReturn(ITEM);
        //When
        underTest.process(PARAM);
        //Then
        then(consumer).should().consume(ITEM);
    }
}