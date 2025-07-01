package am.capstone.model.validators.annotations;

import am.capstone.model.validators.StateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StateValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface StateConstraint {
    Class<? extends Enum<?>> enumClass();
    String message() default "Incorrect State";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
