package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {
    WebDriver driver;
    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Edit your account information")
    private WebElement editAccountInformationLink;
    @FindBy(id = "input-firstname")
    private WebElement firstnameField;
    @FindBy(id = "input-lastname")
    private WebElement lastnameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successBanner;
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropdown;
    @FindBy(xpath = "//ul/li/a[text()='Logout']")
    private WebElement logoutButton;

    public void openEditAccountInformationPage() { editAccountInformationLink.click(); }
    public String getAccountPageTitle() {
        return driver.getTitle();
    }
    public void enterPersonalDetails(String firstname, String lastname, String email, String telephone) {
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
        lastnameField.clear();
        lastnameField.sendKeys(lastname);
        emailField.clear();
        emailField.sendKeys(email);
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }
    public void clickContinue() { continueButton.click(); }
    public String getSuccessMessage() {
        return successBanner.getText();
    }
    public void performMyAccountLogout() {
        myAccountDropdown.click();
        logoutButton.click();
    }
}
