package qa.custom.api.model.pojo.teacherInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qa.custom.api.model.pojo.addklass.AddKlassResponseInfo;
import qa.custom.api.model.response.StudentResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherKlassInfo {
    private WebService webService ;
    private SchoolService schoolService ;
    private List<StudentResponse> studentResponses ;
    private List<AddKlassResponseInfo> addedKlassResponseInfos ;
}
