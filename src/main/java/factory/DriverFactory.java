package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    //This method is used to initialize a thread local driver on the basis of selected browser
    public WebDriver init_driver(String browser) {
        if(browser.equalsIgnoreCase("chrome"))
            tlDriver.set(new ChromeDriver());
        else if(browser.equalsIgnoreCase("firefox"))
            tlDriver.set(new FirefoxDriver());
        else if(browser.equalsIgnoreCase("safari"))
            tlDriver.set(new SafariDriver());
        else System.out.println("Invalid browser selected!");

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    //This method is used to get the thread local driver
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
