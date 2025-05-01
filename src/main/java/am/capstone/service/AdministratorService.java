package am.capstone.service;

import am.capstone.model.Administrator;
import am.capstone.repository.AdministratorRepository;
import am.capstone.service.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministratorService {
    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Administrator getAdministratorById(Long id) {
        return administratorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrator not found with ID: " + id));
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Administrator updateAdministrator(Long id, Administrator updatedAdministrator) {
        Administrator existing = getAdministratorById(id);
        existing.setFirstName(updatedAdministrator.getFirstName());
        existing.setLastName(updatedAdministrator.getLastName());
        existing.setEmail(updatedAdministrator.getEmail());
        return administratorRepository.save(existing);
    }

    public void deleteAdministrator(Long id) {
        Administrator administrator = getAdministratorById(id);
        administratorRepository.delete(administrator);
    }
}
