package qa.customtype;

import io.cucumber.java.DataTableType;
import qa.domainobjects.AssessmentDetails;
import qa.domainobjects.LoginDetails;

import java.util.Map;

public class CustomDataTableTypeDummy {

    //@DataTableType
    public LoginDetails loginDetailsEntry(Map<String, String> entry){
        return new LoginDetails(entry.get("userEmail"), entry.get("userPassword")) ;
    }
    //@DataTableType
    public AssessmentDetails assessmentDetails(Map<String, String> assessmentEntry){
        return new AssessmentDetails(assessmentEntry.get("klass_id"),
                assessmentEntry.get("assessment_name"),
                assessmentEntry.get("module_id"));
    }

}
