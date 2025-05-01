package am.capstone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    private Long courseId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @NotBlank
    private Instructor instructor;

    @NotBlank
    private int credits;

    @NotBlank
    private int capacity;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> studentsEnrolled = new HashSet<>();

}