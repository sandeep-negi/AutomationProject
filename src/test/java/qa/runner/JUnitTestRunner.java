package qa.runner;/*

// If we are using TESTNG then we have to comment this JUNIT

// Feature Files wil run in Parallel and not Scenarios

package qa.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/qa"
        , glue = {"qa"}
        , plugin = { "json:target/cucumber-report/cucumber.json", "pretty", "html:target/cucumber-report/cucumber.html" })
public class JUnitTestRunner {
}

*/



