package parallel;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps();
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");

        DriverFactory.getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/login");
        accountPage = new AccountPage(loginPage.performLogin(username, password));
    }
    @Given("user is on account page")
    public void user_is_on_account_page() {
        accountPage.getPageTitle();
    }
    @Then("user gets account section")
    public void user_gets_account_section(DataTable dataTable) {
        List<String> expectedAccountSectionList  = dataTable.asList();
        Assert.assertEquals("Account section list mismatch", expectedAccountSectionList, accountPage.getAccountSectionList());

    }
    @Then("account section count should be {int}")
    public void account_section_count_should_be(int expectedAccountSectionCount) {
        Assert.assertEquals("Account section count mismatch", expectedAccountSectionCount, accountPage.getAccountSectionCount());
    }
}
