package am.capstone.repository;

import am.capstone.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id);

    Course save(Course course);

    List<Course> findAll();

    void deleteById(Long id);

    void delete(Course entity);

}