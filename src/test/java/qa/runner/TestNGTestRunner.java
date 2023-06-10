
package qa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/qa"
        , glue = {"qa.stepDefinitions", "qa.customtype"}
        , plugin = { "json:target/cucumber-report/cucumber.json", "pretty", "html:target/cucumber-report/cucumber.html" }
        , snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}





