package am.capstone.service;

import am.capstone.model.Faculty;
import am.capstone.repository.FacultyRepository;
import am.capstone.service.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found with ID: " + id));
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Faculty existing = getFacultyById(id);
        existing.setFirstName(updatedFaculty.getFirstName());
        existing.setLastName(updatedFaculty.getLastName());
        existing.setEmail(updatedFaculty.getEmail());
        return facultyRepository.save(existing);
    }

    public void deleteFaculty(Long id) {
        Faculty faculty = getFacultyById(id);
        facultyRepository.delete(faculty);
    }
}
