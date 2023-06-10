package qa.context;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import qa.domainobjects.Cookies;

import java.util.HashMap;
import java.util.Map;

@Data
public class TestContext {
    public WebDriver driver ;
    public String scenarioName ;
    private Map<String, Object> customStorage = new HashMap<>();
    private DomainObjectContext domainObjectContext = new DomainObjectContext();
    public Cookies cookies ;
    public String sessionId;
    public String jwtToken ;
    public static String url;
    private APIContext apiContext = new APIContext();
    private Map<String, String> data = new HashMap<>();

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
    public void addToCustomStorage(String k, Object v) {
        customStorage.put(k, v);
    }

//    @Override
//    public String toString() {
//        return String.format("RunId: %s, Browser: %s, Test: %s, Data: %s", runId, browser, testId, data.toString());
//    }

}
