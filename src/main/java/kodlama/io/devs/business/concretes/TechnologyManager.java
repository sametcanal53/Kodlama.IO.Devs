package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyManager implements TechnologyService{

    private final TechnologyRepository technologyRepository;

    @Override
    public List<Technology> getAll() {
        return this.technologyRepository.findAll();
    }

    @Override
    public Technology getById(int id) {
        if(!technologyRepository.existsById(id))
            throw new RuntimeException("Technology Not Found!");
        return this.technologyRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Technology> add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = Technology
                .builder()
                .programmingLanguageId(createTechnologyRequest.getProgrammingLanguageId())
                .name(createTechnologyRequest.getName())
                .build();

        return ResponseEntity.ok().body(this.technologyRepository.save(technology));
    }

    @Override
    public ResponseEntity<Technology> update(UpdateTechnologyRequest updateTechnology) {
        if(!technologyRepository.existsById(updateTechnology.getId()))
            throw new RuntimeException("Technology Not Found!");
        Technology technology = this.technologyRepository.findById(updateTechnology.getId()).orElse(null);
        technology.setId(updateTechnology.getId());
        technology.setName(updateTechnology.getName());
        technology.setProgrammingLanguageId(updateTechnology.getProgrammingLanguageId());
        return ResponseEntity.ok().body(this.technologyRepository.save(technology));
    }

    @Override
    public Boolean delete(int id) {
        if(!technologyRepository.existsById(id)){
            throw new RuntimeException("Technology Not Found!");
        }
        this.technologyRepository.deleteById(id);
        return true;
    }
}
