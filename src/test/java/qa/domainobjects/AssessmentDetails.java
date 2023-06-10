package qa.domainobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AssessmentDetails {
    private String klassId ;
    private String assessmentName;
    private String moduleId ;
}
