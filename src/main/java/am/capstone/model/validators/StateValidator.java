package am.capstone.model.validators;

import am.capstone.model.enums.State;
import am.capstone.model.validators.annotations.StateConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class StateValidator implements ConstraintValidator<StateConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        try {
            State.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}