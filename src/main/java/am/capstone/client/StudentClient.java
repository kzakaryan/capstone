package am.capstone.client;

import am.capstone.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

// Added for checking Load Balancing
@FeignClient(name = "capstone")
public interface StudentClient {

    @GetMapping("/students")
    ResponseEntity<Page<Student>> getAll();
}
