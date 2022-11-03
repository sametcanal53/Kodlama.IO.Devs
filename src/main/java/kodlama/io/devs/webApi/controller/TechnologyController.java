package kodlama.io.devs.webApi.controller;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping("/")
    public List<Technology> getAll() {
        return this.technologyService.getAll();
    }

    @GetMapping("/{id}")
    public Technology getById(@PathVariable int id) {
        return this.technologyService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Technology> add(@RequestBody() CreateTechnologyRequest createTechnologyRequest) {
        return this.technologyService.add(createTechnologyRequest);
    }

    @PatchMapping("/")
    public ResponseEntity<Technology> update(@RequestBody() UpdateTechnologyRequest updateTechnology) {
        return this.technologyService.update(updateTechnology);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return this.technologyService.delete(id);
    }
}
