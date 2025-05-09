package am.capstone.model;

import am.capstone.model.enums.State;
import am.capstone.model.validators.annotations.PasswordConstraint;
import am.capstone.model.validators.annotations.StateConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    private Long adminId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @PasswordConstraint
    private String password;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @StateConstraint(enumClass = State.class)
    private String state;

    @NotBlank
    private String zip;

}