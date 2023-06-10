package qa.custom.api.operations;

import io.restassured.response.Response;
import qa.custom.api.endpoints.StudentEndPoint;
import qa.custom.entity.model.Student;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static qa.custom.api.RestAssuredHelper.getRequestSpecificationForAutomationService;

public class StudentAPI {


    public static Response completePlayable(Student student, String subject, int learningObjectiveId, int playableId) {

        Map<String, Object> queryParams = new HashMap();
        queryParams.put("studentId", student.getId());
        queryParams.put("subject", subject);
        queryParams.put("learningObjectiveId", learningObjectiveId);
        queryParams.put("playableId", playableId);

        Response response = given(getRequestSpecificationForAutomationService()).queryParams(queryParams).
                post(StudentEndPoint.COMPLETE_PLAYABLE).then().statusCode(200).extract().response();
        return response;
    }

    public static Response completeLearningPath(Student student, String subject) {

        Map<String, String> queryParams = new HashMap();
        queryParams.put("studentId", student.getId());
        queryParams.put("subject", subject);

        Response response = given(getRequestSpecificationForAutomationService()).pathParams(queryParams).
                post(StudentEndPoint.COMPLETE_LEARNING_PATH).then().assertThat().statusCode(200).extract().response();
        return response;
    }

}
