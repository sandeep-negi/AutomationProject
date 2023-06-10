package qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.prompt_for_download", "false");
        prefs.put("download.directory_upgrade", "true");
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        switch (browser) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions()
                        .addArguments("--no-sandbox")
                        .addArguments("disable-extensions")
                        .setExperimentalOption("prefs", prefs)
                        .setExperimentalOption("excludeSwitches", new String[]{"enable-automation"})
                        .addArguments("--disable-notifications")
                        .addArguments("start-maximized")
                        .addArguments("--disable-dev-shm-usage")
                        .addArguments("--remote-allow-origins=*")
                        .addArguments("--disable-gpu");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
