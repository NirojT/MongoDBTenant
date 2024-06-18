package Tenant.All;

import java.util.List;

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
    public void save(@RequestBody Choir choir) {
        choirService.saveChoir(choir);
    }

    @GetMapping("get")
    public List<Choir> getAll() {
        return choirService.getAllChoirs();
    }
}