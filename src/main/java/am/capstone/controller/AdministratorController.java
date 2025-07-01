package am.capstone.controller;

import am.capstone.model.Administrator;
import am.capstone.service.AdministratorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    private final AdministratorService service;

    public AdministratorController(AdministratorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Administrator> create(@Valid @RequestBody Administrator administrator) {
        return ResponseEntity.ok(service.createAdministrator(administrator));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAdministratorById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Administrator>> getAllAdministrators(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir ) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return ResponseEntity.ok(service.getAllAdministrators(PageRequest.of(pageNumber, pageSize, sort)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> update(@PathVariable Long id, @Valid @RequestBody Administrator administrator) {
        return ResponseEntity.ok(service.updateAdministrator(id, administrator));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAdministrator(id);
        return ResponseEntity.noContent().build();
    }
}