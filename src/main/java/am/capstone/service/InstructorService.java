package am.capstone.service;

import am.capstone.model.Course;
import am.capstone.model.Instructor;
import am.capstone.repository.CourseRepository;
import am.capstone.repository.InstructorRepository;
import am.capstone.service.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    public InstructorService(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with ID: " + id));
    }

    public Page<Instructor> getAllInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        Instructor existing = getInstructorById(id);
        existing.setFirstName(updatedInstructor.getFirstName());
        existing.setLastName(updatedInstructor.getLastName());
        existing.setEmail(updatedInstructor.getEmail());
        existing.setPhone(updatedInstructor.getPhone());
        return instructorRepository.save(existing);
    }

    public void deleteInstructor(Long id) {
        Instructor instructor = getInstructorById(id);
        instructorRepository.delete(instructor);
    }

    public void assignCourse(Long instructorId, Long courseId) {
        Instructor instructor = getInstructorById(instructorId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + courseId));
        course.setInstructor(instructor);
        courseRepository.save(course);
    }
}
