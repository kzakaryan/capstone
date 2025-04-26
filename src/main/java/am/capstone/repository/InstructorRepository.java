package am.capstone.repository;

import am.capstone.model.Administrator;
import am.capstone.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findById(Long id);

    Instructor save(Instructor instructor);

    List<Instructor> findAll();

    void deleteById(Long id);

    void delete(Instructor entity);

}