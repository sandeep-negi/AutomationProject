package qa.custom.api.operations;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import qa.context.TestContext;
import qa.custom.api.endpoints.TeacherEndPoint;

import static io.restassured.RestAssured.given;

public class TeacherProfileApi {
    private Cookies cookies;

    public TeacherProfileApi(Cookies cookies){
        this.cookies = cookies;
    }

    public Response getTeacherProfile(String sessionId){
        Header header = new Header("content-type", "application/json");
        Headers headers = new Headers(header);

        Response response = given().cookie("_session_id", sessionId).
                baseUri(TestContext.url).
                headers(headers).
                cookies(cookies).
                log().all().
                when().
                get(TeacherEndPoint.PROFILE).
                then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to get Teacher Profile Details" + ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;

    }
}
