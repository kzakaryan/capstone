package am.capstone.model.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateValidatorTest {

    private StateValidator stateValidator;

    @BeforeEach
    void setUp() {
        stateValidator = new StateValidator();
    }

    @Test
    void validState() {
        assertTrue(stateValidator.isValid("CA", null));
        assertTrue(stateValidator.isValid("NY", null));
        assertTrue(stateValidator.isValid("TX", null));
    }

    @Test
    void lowercaseState() {
        assertFalse(stateValidator.isValid("ca", null));
        assertFalse(stateValidator.isValid("ny", null));
    }

    @Test
    void invalidState() {
        assertFalse(stateValidator.isValid("XX", null));
        assertFalse(stateValidator.isValid("California", null));
    }

    @Test
    void nullState() {
        assertFalse(stateValidator.isValid(null, null));
    }
}