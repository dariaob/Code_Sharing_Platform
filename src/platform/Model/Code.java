package platform.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codeStorage")
public class Code {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String code;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Code(){}


    public Code(String title, String code, String date) {
        this.title = title;
        this.code = code;
        this.date = date;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}