package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstarcts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programminglanguagerequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programminglanguagerequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.programminglanguageresponses.GetByIdProgrammingLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;


    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/save")
    public void save(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        programmingLanguageService.save(createProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        programmingLanguageService.update(id, updateProgrammingLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(int id){
        return programmingLanguageService.getById(id);
    }
}
