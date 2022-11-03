package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstarcts.ProgrammingLanguageTechnologyService;
import kodlama.io.Devs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.Devs.business.responses.programminglanguagetechnologyresponses.GetAllProgrammingLanguageTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languagetechnologies")
public class ProgrammingLanguageTechnologiesController {

    ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

    @Autowired
    public ProgrammingLanguageTechnologiesController(ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
        this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguageTechnologyResponse> getAll(){
        return this.programmingLanguageTechnologyService.getAll();
    }

    @PostMapping("/save")
    public void save(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest){
        this.programmingLanguageTechnologyService.save(createProgrammingLanguageTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest){
        this.programmingLanguageTechnologyService.delete(deleteProgrammingLanguageTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequestRequest){
        this.programmingLanguageTechnologyService.update(id,updateProgrammingLanguageTechnologyRequestRequest);
    }
}
