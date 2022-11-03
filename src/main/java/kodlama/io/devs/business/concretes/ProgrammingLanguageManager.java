package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.create.CreateProgrammingLanguage;
import kodlama.io.devs.business.requests.update.UpdateProgrammingLanguage;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    @Override
    public List<ProgrammingLanguage> getAll() {
        return this.programmingLanguageRepository.findAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return this.programmingLanguageRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<ProgrammingLanguage> add(CreateProgrammingLanguage createProgrammingLanguage) {
        for(ProgrammingLanguage programmingLanguage : getAll())
            if(createProgrammingLanguage.getName().equals(programmingLanguage.getName()))
                throw new RuntimeException("Programming Language Name Is Already Registered");
        if(createProgrammingLanguage.getName().isBlank() && createProgrammingLanguage.getName().isEmpty())
            throw new RuntimeException("Programming Language Name Cannot Be Left Blank Or Empty");
        ProgrammingLanguage programmingLanguage = ProgrammingLanguage
                                                    .builder()
                                                    .name(createProgrammingLanguage.getName())
                                                    .build();

        return ResponseEntity.ok().body(this.programmingLanguageRepository.save(programmingLanguage));
    }

    @Override
    public ResponseEntity<ProgrammingLanguage> update(UpdateProgrammingLanguage updateProgrammingLanguage) {
        for(ProgrammingLanguage programmingLanguage : getAll())
            if(updateProgrammingLanguage.getName().equals(programmingLanguage.getName()))
                throw new RuntimeException("Programming Language Name Is Already Registered");
        if(updateProgrammingLanguage.getName().isBlank() && updateProgrammingLanguage.getName().isEmpty())
            throw new RuntimeException("Programming Language Name Cannot Be Left Blank Or Empty");
        if(!programmingLanguageRepository.existsById(updateProgrammingLanguage.getId()))
            throw new RuntimeException("Programming Language Not Found!");
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingLanguage.getId()).orElse(null);
        programmingLanguage.setId(updateProgrammingLanguage.getId());
        programmingLanguage.setName(updateProgrammingLanguage.getName());
        return ResponseEntity.ok().body(this.programmingLanguageRepository.save(programmingLanguage));
    }

    @Override
    public Boolean delete(int id) {
        if(!programmingLanguageRepository.existsById(id)){
            throw new RuntimeException("Programming Language Not Found!");
        }
        this.programmingLanguageRepository.deleteById(id);
        return true;
    }
}
