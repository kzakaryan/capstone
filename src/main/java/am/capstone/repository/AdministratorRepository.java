package am.capstone.repository;

import am.capstone.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findById(Long id);

    Administrator save(Administrator administrator);

    List<Administrator> findAll();

    void deleteById(Long id);

    void delete(Administrator entity);

}