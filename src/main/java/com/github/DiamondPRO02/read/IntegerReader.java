package com.github.DiamondPRO02.read;

import com.github.DiamondPRO02.validation.IntegerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntegerReader {
    private final ValidationReader validationReader;
    private final IntegerValidator integerValidator;

    public int readNumber() {
        String numberString = validationReader.readInput(integerValidator);

        return Integer.parseInt(numberString);
    }
}
