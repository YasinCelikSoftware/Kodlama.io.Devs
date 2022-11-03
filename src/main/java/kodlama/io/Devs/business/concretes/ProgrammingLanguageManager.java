package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstarcts.ProgrammingLanguageService;
import kodlama.io.Devs.business.abstarcts.ProgrammingLanguageTechnologyService;
import kodlama.io.Devs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Devs.dataaccess.abstarcts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }



    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();

        for(ProgrammingLanguage programmingLanguage : programmingLanguages){
            GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
            response.setName(programmingLanguage.getName());

            programmingLanguageResponses.add(response);
        }

        return programmingLanguageResponses;

    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
        response.setName(programmingLanguage.getName());

        return response;
    }

    @Override
    public void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        if(programmingLanguageExistValidator(createProgrammingLanguageRequest) && programmingLanguageNameValidator(createProgrammingLanguageRequest)){
            ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
            programmingLanguage.setName(createProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);

        }
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
    }

    @Override
    public void update(int id , UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        if(!updateProgrammingLanguageRequest.getName().isEmpty()){

            ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);

        }

    }

    public boolean programmingLanguageNameValidator(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        if(createProgrammingLanguageRequest.getName().isEmpty())
            System.out.println("This language name is empty or blank.");
        return !createProgrammingLanguageRequest.getName().isEmpty();

    }

    public boolean programmingLanguageExistValidator(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

        for (ProgrammingLanguage tempProgrammingLanguage : programmingLanguageRepository.findAll()) {
            if (tempProgrammingLanguage.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {

                System.out.println("This coding language is already exists.");
                return false;

            }
        }

        return true;

    }
}
