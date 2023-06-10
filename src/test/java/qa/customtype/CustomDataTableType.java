package qa.customtype;

import io.cucumber.java.DataTableType;
import qa.context.TestContext;
import qa.domainobjects.AssessmentDetails;
import qa.domainobjects.LoginDetails;
import qa.domainobjects.StudentLoginDetails;

import java.util.HashMap;
import java.util.Map;

public class CustomDataTableType {

    private TestContext testContext ;

    public CustomDataTableType(TestContext testContext) {
        this.testContext = testContext;
    }

    @DataTableType
    public LoginDetails loginDetailsEntry(Map<String, String> dataTable){
        Map<String, String> data = new HashMap<>();
        data.put("username", dataTable.get("userEmail"));
        data.put("password", dataTable.get("userPassword"));
        return new LoginDetails(data.get("username"),data.get("password"));
    }

    @DataTableType
    public StudentLoginDetails studentLoginDetailsEntry(Map<String, String> dataTable){
        Map<String, String> data = new HashMap<>();
        data.put("studentName" ,"");
        data.put("studentId" ,"");
        data.put("studentPassword" ,"");
        return new StudentLoginDetails(data.get("studentName"),data.get("studentId"),data.get("studentPassword"));
    }

    @DataTableType
    public AssessmentDetails assessmentDetails(Map<String, String> assessmentDataTable){
        Map<String, String> data = new HashMap<>();
        data.put("klass_id", assessmentDataTable.get("klass_id"));
        data.put("assessment_name", assessmentDataTable.get("assessment_name"));
        data.put("module_id", assessmentDataTable.get("module_id"));

        AssessmentDetails assessmentDetails = new AssessmentDetails(data.get("klass_id"),
                data.get("assessment_name"),
                data.get("module_id"));

        return new AssessmentDetails(assessmentDetails.getKlassId(),
                assessmentDetails.getAssessmentName(),
                assessmentDetails.getModuleId());
    }

}
