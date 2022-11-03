package kodlama.io.Devs.business.requests.programminglanguagetechnologyrequests;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProgrammingLanguageTechnologyRequest {

    private String name;
    private int programmingLanguageId;

}
