package qa.custom.api.model.pojo.addklass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AddKlassResponseInfo {
    private String id;
    private String name;
    private String slug;
    @JsonProperty("grade_id")
    private String gradeId;
    @JsonProperty("students_count")
    private int studentsCount;
    @JsonProperty("school_year")
    private int schoolYear ;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("teacher_id")
    private String teacherId;
    @JsonProperty("secondary_klass")
    private boolean secondaryKlass ;
}
