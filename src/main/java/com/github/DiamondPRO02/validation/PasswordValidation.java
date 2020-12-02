package com.github.DiamondPRO02.validation;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PasswordValidation implements Predicate<String> {
    @Override
    public boolean test(String password) {
        if(password.length() < 3){
            System.out.println("Password too short (Minimum 3 charachters)");
            return false;
        }
        return true;
    }
}
