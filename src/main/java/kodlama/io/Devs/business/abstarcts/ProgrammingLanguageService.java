package kodlama.io.Devs.business.abstarcts;

import kodlama.io.Devs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguageResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id);
    void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
    void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);


}
