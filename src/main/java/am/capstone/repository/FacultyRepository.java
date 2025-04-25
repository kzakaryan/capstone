package am.capstone.repository;

import am.capstone.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findById(Long id);

    Faculty save(Faculty faculty);

}