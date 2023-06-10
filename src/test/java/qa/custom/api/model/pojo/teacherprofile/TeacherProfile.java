package qa.custom.api.model.pojo.teacherprofile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import qa.custom.api.model.pojo.teacherInfo.Klasses;
import qa.custom.api.model.pojo.teacherInfo.Teacher;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class TeacherProfile {
    private Teacher teacher ;
    private List<Klasses> klasses;
}
