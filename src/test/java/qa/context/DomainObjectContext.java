package qa.context;

import lombok.Data;
import qa.custom.api.model.onboardingstates.UserOnBoardingState;
import qa.custom.api.model.pojo.teacherInfo.TeacherKlassInfo;
import qa.custom.api.model.response.StudentResponse;
import qa.domainobjects.AssessmentDetails;
import qa.domainobjects.LoginDetails;
import qa.domainobjects.StudentLoginDetails;

import java.util.List;


@Data
public class DomainObjectContext {
    private LoginDetails loginDetails ;
    private AssessmentDetails assessmentDetails ;
    private StudentLoginDetails studentLoginDetails;
    private List<StudentResponse> studentResponse;
    private UserOnBoardingState userOnBoardingState ;
    private TeacherKlassInfo teacherKlassInfo ;
}
