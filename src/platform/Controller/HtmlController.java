package platform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.Model.Code;
import platform.Service.CodeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {
    private CodeService codeRepo;
    private Code code;
    public HtmlController() {}

    @Autowired
    public HtmlController(CodeService codeRepo) {
        this.codeRepo = codeRepo;
    }


    @GetMapping(path = "/code/{id}", produces = "text/html")
    public String getHtmlCode(@PathVariable("id") int id, Model model) {

        Code responseCode = codeRepo.getCodeList(id);
        model.addAttribute("code", responseCode);

        return "code";
    }

    @GetMapping(path = "/code/latest", produces = "text/html")
    public String getHtmlLatestCode(Model model) {
        List<Code> lastCodesStore = new ArrayList<>();

        for (int i = codeRepo.lastIndex(); i >= codeRepo.limitOutput(); i--) {
            Code eachCode = codeRepo.getCodeList(i);
            lastCodesStore.add(eachCode);
        }
        model.addAttribute("code", lastCodesStore);

        return "lastcodes";
    }


    @GetMapping(path = "/code/new", produces = "text/html")
    public String getHtmlCodeNew() {
        return "newcode";
    }

}
