package am.capstone.model.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void validPassword() {
        assertTrue(passwordValidator.isValid("Password1!", null));
        assertTrue(passwordValidator.isValid("Aa1@3456", null));
        assertTrue(passwordValidator.isValid("Valid$123", null));
    }

    @Test
    void shortPassword() {
        assertFalse(passwordValidator.isValid("P1!a", null));
    }

    @Test
    void missingUppercase() {
        assertFalse(passwordValidator.isValid("password1!", null));
    }

    @Test
    void missingLowercase() {
        assertFalse(passwordValidator.isValid("PASSWORD1!", null));
    }

    @Test
    void missingDigit() {
        assertFalse(passwordValidator.isValid("Password!", null));
    }

    @Test
    void missingSpecialCharacter() {
        assertFalse(passwordValidator.isValid("Password1", null));
    }

    @Test
    void nullPassword() {
        assertFalse(passwordValidator.isValid(null, null));
    }

}