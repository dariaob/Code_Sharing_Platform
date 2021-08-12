package platform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.Model.Code;
import platform.Repository.Repository;
import platform.Util.Util;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private Repository codeRepo;


    public ApiController() {}

    @Autowired
    public ApiController(Repository codeRepo) {
        this.codeRepo = codeRepo;
    }

    @GetMapping(path = "/api/code/{id}", produces = "application/json;charset=utf-8")
    public Code getApiId (@PathVariable("id") int id) {
        return codeRepo.getCodeList().get(id - 1);
    }


    @GetMapping(path = "/api/code/latest", produces = "application/json;charset=utf-8")
    public Object[] getApiLatest() {
        List<Code> code = new ArrayList<>();
        for (int i = codeRepo.lastIndex(); i >= codeRepo.limitOutput(); i--) {
            Code codeData = codeRepo.getCodeList().get(i);
            code.add(codeData);
        }
        return code.toArray();
    }

    @PostMapping(path = "/api/code/new", produces = "application/json;charset=utf-8")
    public String setApiCode(@RequestBody Code newRepo) {
        Code repos = new Code();
        repos.setCode(newRepo.getCode());
        repos.setTitle("Code");
        repos.setDate(Util.getDate());
        codeRepo.getCodeList().add(repos);
        String response = "{ \"id\" : \"" + codeRepo.getCodeList().size() + "\" }";
        return response;
    }
}
