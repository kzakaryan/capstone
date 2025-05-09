package am.capstone.model;
import am.capstone.model.enums.State;
import am.capstone.model.validators.annotations.PasswordConstraint;
import am.capstone.model.validators.annotations.StateConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

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

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> coursesEnrolled = new HashSet<>();

    @NotBlank
    private int credits;

}