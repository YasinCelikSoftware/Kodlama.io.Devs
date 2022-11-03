package kodlama.io.Devs.dataaccess.abstarcts;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {



}
