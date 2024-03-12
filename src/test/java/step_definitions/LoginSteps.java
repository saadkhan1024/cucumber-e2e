package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private String actualTitle;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        actualTitle = loginPage.getPageTitle();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertEquals("Page title mismatch", expectedTitle, actualTitle);
    }
    @Then("forgotten password link should be displayed")
    public void forgotten_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed());
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }
}
