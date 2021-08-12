package platform.Repository;

import org.springframework.stereotype.Component;
import platform.Model.Code;

import java.util.ArrayList;
import java.util.List;

    @Component
    public class Repository {
        List <Code> codeList = new ArrayList<>();
        int pageNum = 10;

        public List<Code> getCodeList() {
            return codeList;
        }

        public void setCodeList(List<Code> codeList) {
            this.codeList = codeList;
        }

        public int lastIndex() {
            return codeList.size() - 1;
        }

        public int limitOutput() {
            return codeList.size() % pageNum == codeList.size() ? 0 : codeList.size() % pageNum;
        }
    }

