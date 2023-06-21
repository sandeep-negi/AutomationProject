package qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import qa.utils.ConfigLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static qa.constants.SplashLearnConstants.DOCKER_DOWNLOAD_DIRECTORY;
import static qa.constants.SplashLearnConstants.LOCAL_DOWNLOAD_DIRECTORY;

public class DriverFactory {
    private static final String HUB = "http://localhost:4444/wd/hub";
    public static boolean jenkins;
    public static boolean killBrowser;
    public static String runmode;
    public static boolean headless;

    public static WebDriver initializeDriver(String browser) throws MalformedURLException {

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


                if (headless) {
                    chromeOptions.setHeadless(headless);
                    chromeOptions.addArguments("--window-size=1280,800");
                }
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().deleteAllCookies();

            }
            case "firefox" -> {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("marionette", true);

                firefoxOptions.addPreference("browser.download.folderList", 2);
                firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls");

                if (Boolean.TRUE.equals(jenkins)) {
                    firefoxOptions.addPreference("browser.download.dir", DOCKER_DOWNLOAD_DIRECTORY);
                    firefoxOptions.setHeadless(true)
                            .addArguments("disable-gpu")
                            .addArguments("window-size=1400,900");

                    firefoxOptions.setCapability("platform", "LINUX");

                    driver = new RemoteWebDriver(new URL(HUB), firefoxOptions);
                } else {
                    firefoxOptions.addPreference("browser.download.dir", LOCAL_DOWNLOAD_DIRECTORY);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                }
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

}
