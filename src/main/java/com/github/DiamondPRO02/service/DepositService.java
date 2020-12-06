package com.github.DiamondPRO02.service;

import com.github.DiamondPRO02.read.IntegerValidationReader;
import com.github.DiamondPRO02.repository.user.User;
import com.github.DiamondPRO02.repository.user.UserRepository;
import com.github.DiamondPRO02.validation.PositiveNumberValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepositService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;
    private final UserRepository userRepository;

    public void deposit(User user) {
        System.out.println("How much do you want to deposit?");
        int depositValue = integerValidationReader.readNumber(positiveNumberValidation);

        user.increaseBalance(depositValue);

        userRepository.save(user);

        System.out.println("Deposit successful.");
    }
}
