package com.github.DiamondPRO02.dependencies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class BusinessLogicTest2 {
    private static final String ITEM = "item";
    private static final String PARAM = "param";

    @Mock
    private Provider provider;
    @Mock
    private Consumer consumer;
    @InjectMocks
    private BusinessLogic underTest;

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