package qa.custom.api.operations;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import qa.constants.EndPoint;
import qa.context.TestContext;
import qa.custom.api.endpoints.TeacherEndPoint;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginApi {
    private Cookies cookies;

    public LoginApi(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    public Response doLogin(String userEmail, String password){
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("user[login]", userEmail);
        formParams.put("user[password]", password);
        formParams.put("user[remember_me]", "0");
        formParams.put("commit", "Login");

        cookies = new Cookies();
        Response response = ApiRequest.post(EndPoint.API_SIGN_IN.url, headers, formParams, cookies);
        if((response.getStatusCode() == 200 ) || (response.getStatusCode() == 302)){
            this.cookies = response.getDetailedCookies();
        }
        else{
            throw new RuntimeException("Failed to Login with email = " + userEmail + " " +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        return response;
    }

    public Response enterKlassCode(String klassCode){
        Header header = new Header("content-type", "text/html");
        Headers headers = new Headers(header);

        Response response = given().
                baseUri(TestContext.url).
                headers(headers).
                formParam("klass_code",klassCode).
                cookies(cookies).
                log().all().
                when().
                post(TeacherEndPoint.KLASS_CODE_LOGIN).
                then().
                log().all().
                extract().
                response();
        if((response.getStatusCode() == 200 ) || (response.getStatusCode() == 302)){
            this.cookies = response.getDetailedCookies();
        }
        else{
            throw new RuntimeException("Failed to Login with email = " + klassCode + " " +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        return response;
    }
}
