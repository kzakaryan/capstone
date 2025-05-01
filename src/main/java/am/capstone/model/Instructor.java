package am.capstone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    private Long instructorId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zip;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> coursesAssigned;
}
