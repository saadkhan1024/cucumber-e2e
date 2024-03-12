package parallel;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class LoginHook {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_property();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browser = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browser);
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            //Take screenshot
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] failScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failScreenshot, "image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }
}
