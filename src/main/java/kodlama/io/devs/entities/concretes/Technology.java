package kodlama.io.devs.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "technology")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","programmingLanguage","programmingLanguageId"})
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "programming_language_id")
    private int programmingLanguageId;

    @ManyToOne()
    @JoinColumn(name = "programming_language_id", insertable = false, updatable = false)
    private ProgrammingLanguage programmingLanguage;
}
