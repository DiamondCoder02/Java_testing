package com.github.DiamondPRO02.menu;

import com.github.DiamondPRO02.read.ValidationReader;
import com.github.DiamondPRO02.repository.user.User;
import com.github.DiamondPRO02.repository.user.UserRepository;
import com.github.DiamondPRO02.validation.PasswordValidation;
import com.github.DiamondPRO02.validation.UsernameValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationMenu implements Menu {
    private final ValidationReader validationReader;
    private final UsernameValidation usernameValidation;
    private final PasswordValidation passwordValidation;
    private final UserRepository userRepository;

    @Value("${registration.startBalance}")
    private int startBalance;

    @Override
    public void enterMenu() {
        System.out.println();
        System.out.println("Registering user...");
        System.out.println("Username:");
        String username = validationReader.readInput(usernameValidation);

        System.out.println();
        System.out.println("Password:");
        String password = validationReader.readInput(passwordValidation);

        User user = User.builder()
                .username(username)
                .password(password)
                .balance(startBalance)
                .build();
        userRepository.save(user);

        System.out.println("Registration successful.");
    }
}
