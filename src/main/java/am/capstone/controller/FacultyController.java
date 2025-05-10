package am.capstone.controller;

import am.capstone.model.Faculty;
import am.capstone.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Faculty> create(@Valid @RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.createFaculty(faculty));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFacultyById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Faculty>> getAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir ) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return ResponseEntity.ok(service.getAllFaculties(PageRequest.of(pageNumber, pageSize, sort)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> update(@PathVariable Long id, @Valid @RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.updateFaculty(id, faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
