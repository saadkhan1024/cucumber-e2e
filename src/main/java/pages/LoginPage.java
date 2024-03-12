package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(linkText = "Forgotten Password")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public String getPageTitle() {
        return driver.getTitle();
    }
    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }
    public void enterUsername(String username) {
        emailField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLogin() {
        loginButton.click();
    }

    public WebDriver performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return driver;
    }
}
