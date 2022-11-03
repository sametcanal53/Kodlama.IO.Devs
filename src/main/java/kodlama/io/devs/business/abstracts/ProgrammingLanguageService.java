package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.create.CreateProgrammingLanguage;
import kodlama.io.devs.business.requests.update.UpdateProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    ResponseEntity<ProgrammingLanguage> add(CreateProgrammingLanguage createProgrammingLanguage);
    ResponseEntity<ProgrammingLanguage> update(UpdateProgrammingLanguage updateProgrammingLanguage);
    Boolean delete(int id);

}
