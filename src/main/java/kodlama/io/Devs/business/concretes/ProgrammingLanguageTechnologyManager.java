package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstarcts.ProgrammingLanguageTechnologyService;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.responses.programminglanguagetechnologyresponses.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.Devs.dataaccess.abstarcts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataaccess.abstarcts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguageTechnology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

    private ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingLanguageTechnologyRepository,
                                                ProgrammingLanguageRepository programmingLanguageRepository){

        this.programmingLanguageTechnologyRepository = programmingLanguageTechnologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;

    }

    @Override
    public List<GetAllProgrammingLanguageTechnologyResponse> getAll() {

        List<ProgrammingLanguageTechnology> programmingLanguageTechnologies = programmingLanguageTechnologyRepository.findAll();
        List<GetAllProgrammingLanguageTechnologyResponse> responses = new ArrayList<>();

        for (ProgrammingLanguageTechnology programmingLanguageTechnology: programmingLanguageTechnologies) {
            GetAllProgrammingLanguageTechnologyResponse response = new GetAllProgrammingLanguageTechnologyResponse();

            response.setName(programmingLanguageTechnology.getName());
            response.setLanguageName(programmingLanguageTechnology.getProgrammingLanguage().getName());

            responses.add(response);
        }
        return responses;
    }

    @Override
    public void save(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) {

        ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
        ProgrammingLanguage programmingLanguage =
                programmingLanguageRepository.findById(createProgrammingLanguageTechnologyRequest.getProgrammingLanguageId()).get();

        programmingLanguageTechnology.setName(createProgrammingLanguageTechnologyRequest.getName());
        programmingLanguageTechnology.setProgrammingLanguage(programmingLanguage);

        programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
    }

    @Override
    public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {

            programmingLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getId());

    }

    @Override
    public void update(int id, UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {

            ProgrammingLanguageTechnology programmingLanguageTechnology =
                    programmingLanguageTechnologyRepository.findById(id).get();

            ProgrammingLanguage programmingLanguage
                    = programmingLanguageRepository.findById(updateProgrammingLanguageTechnologyRequest.getProgrammingLanguageId()).get();

            programmingLanguageTechnology.setName(updateProgrammingLanguageTechnologyRequest.getName());
            programmingLanguageTechnology.setProgrammingLanguage(programmingLanguage);

            programmingLanguageTechnologyRepository.save(programmingLanguageTechnology);
    }


}
