package am.capstone.repository;

import am.capstone.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);

    Student save(Student student);

    List<Student> findAll();

    void deleteById(Long id);

    void delete(Student entity);

}