package platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.Model.Code;
import platform.Repository.CodeRepository;
import platform.exception.CodeNotFoundException;

import java.util.Optional;

@Service
public class CodeService {
    private final int PAGESNUMBER  = 10;
    CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

     public void addToSave(Code code) {
        long counter = codeRepository.count() + 1;
        code.setId((int) counter);
        codeRepository.save(code);
     }

     public Code getCodeList(int id) {
         Optional <Code> requiredCode = codeRepository.findById(id);
         if (requiredCode.isEmpty()) {
             throw new CodeNotFoundException();
         } else {
            return requiredCode.get();
         }
     }

     public int lastIndex() {
        return (int) codeRepository.count();
     }

     public int limitOutput() {
        return (int) (codeRepository.count() % PAGESNUMBER == codeRepository.count() ?
                1 : codeRepository.count() % PAGESNUMBER + 1);
     }
}
