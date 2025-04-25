package am.capstone.repository;

import am.capstone.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findById(Long id);

    Administrator save(Administrator administrator);

}