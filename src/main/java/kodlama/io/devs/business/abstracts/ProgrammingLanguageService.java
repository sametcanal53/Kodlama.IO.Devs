package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.create.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.update.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    ResponseEntity<ProgrammingLanguage> add(CreateProgrammingLanguageRequest createProgrammingLanguage);
    ResponseEntity<ProgrammingLanguage> update(UpdateProgrammingLanguageRequest updateProgrammingLanguage);
    Boolean delete(int id);

}
