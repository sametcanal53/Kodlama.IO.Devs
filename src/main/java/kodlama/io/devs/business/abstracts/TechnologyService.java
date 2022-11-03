package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TechnologyService {
    List<Technology> getAll();
    Technology getById(int id);
    ResponseEntity<Technology> add(CreateTechnologyRequest createTechnologyRequest);
    ResponseEntity<Technology> update(UpdateTechnologyRequest updateTechnology);
    Boolean delete(int id);
}
