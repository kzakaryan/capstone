package am.capstone.controller;

import am.capstone.model.Administrator;
import am.capstone.service.AdministratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/administrators")
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
    public ResponseEntity<List<Administrator>> getAll() {
        return ResponseEntity.ok(service.getAllAdministrators());
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