package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.junit.Assume;
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

    @Before(value = "@Skip", order = 0)
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario: " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_property();
    }

    @Before(order = 2)
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
