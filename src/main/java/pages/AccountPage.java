package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#content h2")
    List<WebElement> accountSections;

    public void getPageTitle() {
        driver.getTitle();
    }
    public List<String> getAccountSectionList() {
        List<String> accountSectionList = new ArrayList<>();
        for(WebElement section : accountSections) {
            String sectionText = section.getText();
            accountSectionList.add(sectionText);
        }
        return accountSectionList;
    }
    public int getAccountSectionCount() {
        return accountSections.size();
    }

}
