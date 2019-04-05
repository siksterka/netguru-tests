package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser() {
        System.out.println("Called openBrowser");

        String separator = System.getProperty("file.separator");

        String chromePath = System.getProperty("user.dir")
                + separator + "src"
                + separator + "test"
                + separator + "resources"
                + separator + "chromedriver";

        System.setProperty("webdriver.chrome.driver", chromePath);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
        driver = new ChromeDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
