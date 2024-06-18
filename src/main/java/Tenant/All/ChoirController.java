package Tenant.All;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/choirs")
public class ChoirController {

    private final ChoirService choirService;

    public ChoirController(final ChoirService choirService) {
        this.choirService = choirService;
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Choir choir) {

        choirService.saveChoir(choir);
        return ResponseEntity.status(200).body("created");
    }

    @GetMapping("get")
    public List<Choir> getAll() {
        return choirService.getAllChoirs();
    }
}