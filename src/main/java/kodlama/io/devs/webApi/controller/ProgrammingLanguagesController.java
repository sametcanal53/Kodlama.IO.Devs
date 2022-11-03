package kodlama.io.devs.webApi.controller;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.create.CreateProgrammingLanguage;
import kodlama.io.devs.business.requests.update.UpdateProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ProgrammingLanguagesController {

    private final ProgrammingLanguageService programmingLanguageService;

    @GetMapping("/")
    public List<ProgrammingLanguage> getAll() {
        return this.programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable int id) {
        return this.programmingLanguageService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<ProgrammingLanguage> add(@RequestBody() CreateProgrammingLanguage createProgrammingLanguage) {
        return this.programmingLanguageService.add(createProgrammingLanguage);
    }

    @PatchMapping("/")
    public ResponseEntity<ProgrammingLanguage> update(@RequestBody() UpdateProgrammingLanguage updateProgrammingLanguage) {
        return this.programmingLanguageService.update(updateProgrammingLanguage);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return this.programmingLanguageService.delete(id);
    }

}
