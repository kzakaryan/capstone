package am.capstone.controller;

import am.capstone.model.Instructor;
import am.capstone.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@Valid @RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.createInstructor(instructor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInstructorById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Instructor>> getAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir ) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        return ResponseEntity.ok(service.getAllInstructors(PageRequest.of(pageNumber, pageSize, sort)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Long id, @Valid @RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.updateInstructor(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<Void> assignCourse(@PathVariable Long instructorId, @PathVariable Long courseId) {
        service.assignCourse(instructorId, courseId);
        return ResponseEntity.ok().build();
    }
}
