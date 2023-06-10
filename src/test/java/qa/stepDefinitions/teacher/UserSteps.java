package qa.stepDefinitions.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import qa.apiHelper.TeacherData;
import qa.context.DomainObjectContext;
import qa.context.TestContext;
import qa.custom.api.operations.LoginApi;
import qa.domainobjects.LoginDetails;

import java.util.Map;

public class UserSteps {
    private final TestContext context ;
    private final DomainObjectContext domainObjectContext ;
    private final Map<String, Object> customStorage;
  //  private final Evaluator evaluator = new Evaluator();
    private final WebDriver driver;

    public UserSteps(TestContext context){
        this.context = context;
        driver = context.getDriver();
        customStorage = context.getCustomStorage();
        this.domainObjectContext = context.getDomainObjectContext();
    }

    @And("the user logins using api with details :")
    public void the_user_logins_using_api_with_details(LoginDetails loginDetails) {
        domainObjectContext.setLoginDetails(loginDetails);
        TeacherData teacherData = new TeacherData(context);
        teacherData.getTeacherKlassStudentData(domainObjectContext.getLoginDetails().getUserEmail(),
                domainObjectContext.getLoginDetails().getUserPassword());
        context.cookies.injectCookiesToBrowser(driver);
    }

    @And("the user logins into application")
    public void theUserLoginsIntoApplication(LoginDetails loginDetails) {
        domainObjectContext.setLoginDetails(loginDetails);
        TeacherData teacherData = new TeacherData(context);
//        teacherData.getTeacherKlassStudentData(evaluator.evaluate(context.getData(), context.getData().get("username")),
//                evaluator.evaluate(context.getData(), context.getData().get("password")));
        teacherData.getTeacherKlassStudentData(domainObjectContext.getLoginDetails().getUserEmail(),
                domainObjectContext.getLoginDetails().getUserPassword());
        context.cookies.injectCookiesToBrowser(driver);
    }

}
