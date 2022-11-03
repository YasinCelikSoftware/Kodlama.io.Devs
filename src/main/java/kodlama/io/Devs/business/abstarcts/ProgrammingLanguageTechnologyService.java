package kodlama.io.Devs.business.abstarcts;

import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.responses.programminglanguagetechnologyresponses.GetAllProgrammingLanguageTechnologyResponse;

import java.util.List;

public interface ProgrammingLanguageTechnologyService {

    List<GetAllProgrammingLanguageTechnologyResponse> getAll();
    void save(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest);
    void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest);
    void update(int id, UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest);
}
