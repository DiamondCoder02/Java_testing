package com.github.DiamondPRO02.service;

import com.github.DiamondPRO02.read.IntegerValidationReader;
import com.github.DiamondPRO02.read.ValidationReader;
import com.github.DiamondPRO02.repository.user.User;
import com.github.DiamondPRO02.repository.user.UserRepository;
import com.github.DiamondPRO02.validation.PositiveNumberValidation;
import com.github.DiamondPRO02.validation.UserExistsValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class TransferServiceTest {
    private static final Integer TRANSFER_VALUE = 20;
    private static final String USERNAME_INPUT = "username_input";

    @Mock
    private IntegerValidationReader integerValidationReader;

    @Mock
    private PositiveNumberValidation positiveNumberValidation;

    @Mock
    private ValidationReader validationReader;

    @Mock
    private UserExistsValidator userExistsValidator;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TransferService undertest;

    @Mock
    public User user1;

    @Mock
    public User user2;

    @Test
    public void transfer_shouldCancelTransfer_whenTransferValueIsZero(){
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(0);

        undertest.transfer(user1);

        then(user1).should().getBalance();
        then(user1).shouldHaveNoMoreInteractions();
        then(user2).shouldHaveNoInteractions();
        then(validationReader).shouldHaveNoInteractions();
        then(userRepository).shouldHaveNoInteractions();
    }
    @Test
    public void transfer_shouldCancelTransfer_whenUsernameIsBlank(){
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(TRANSFER_VALUE);
        given(validationReader.readInput(userExistsValidator)).willReturn(" ");
        given(user1.getBalance()).willReturn(TRANSFER_VALUE + 1);

        undertest.transfer(user1);

        then(user1).should(times(2)).getBalance();
        then(user1).shouldHaveNoMoreInteractions();
        then(user2).shouldHaveNoInteractions();
        then(userRepository).shouldHaveNoInteractions();

    }
    @Test
    public void transfer_executeTransfer(){
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(TRANSFER_VALUE);
        given(user1.getBalance()).willReturn(TRANSFER_VALUE + 1);
        given(validationReader.readInput(userExistsValidator)).willReturn(USERNAME_INPUT);
        given(userRepository.findByUsername(USERNAME_INPUT)).willReturn(user2);

        undertest.transfer(user1);

        then(user1).should().decreaseBalance(TRANSFER_VALUE);
        then(user2).should().increaseBalance(TRANSFER_VALUE);
        then(userRepository).should().save(user1);
        then(userRepository).should().save(user2);
    }

    @Test
    public void transfer_shouldRetryTransfer_whenTransferValueIsHigherThanBalance(){
        given(user1.getBalance()).willReturn(TRANSFER_VALUE);
        given(integerValidationReader.readNumber(positiveNumberValidation))
                .willReturn(TRANSFER_VALUE + 1)
                .willReturn(TRANSFER_VALUE);
        given(validationReader.readInput(userExistsValidator)).willReturn(USERNAME_INPUT);
        given(userRepository.findByUsername(USERNAME_INPUT)).willReturn(user2);

        undertest.transfer(user1);

        then(integerValidationReader).should(times(2)).readNumber(positiveNumberValidation);
        then(user1).should().decreaseBalance(TRANSFER_VALUE);
        then(user2).should().increaseBalance(TRANSFER_VALUE);
        then(userRepository).should().save(user1);
        then(userRepository).should().save(user2);
    }
}