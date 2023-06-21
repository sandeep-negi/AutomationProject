package qa.stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import qa.context.TestContext;
import qa.factory.DriverFactory;

import java.net.MalformedURLException;

public class CucumberHooks {
    private WebDriver driver ;
    private final TestContext context ;

    public CucumberHooks(TestContext context){
        this.context = context ;
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
        DriverFactory.jenkins= System.getProperty("jenkins", "false").trim()
                .equalsIgnoreCase("true");
        DriverFactory.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

    @Before
    public void before(Scenario scenario) throws MalformedURLException {
        context.scenarioName = scenario.getName();
        System.out.println("Scenario Name = " + context.scenarioName);
        System.out.println(" Before Thread ID = " + Thread.currentThread().getId() + " == " +scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println(" After Thread ID = " + Thread.currentThread().getId() + " == " +scenario.getName());
        driver.quit();
        System.out.println("Quit Driver");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }
}
