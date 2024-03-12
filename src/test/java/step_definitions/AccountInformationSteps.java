package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.AccountInformationPage;
import pages.LoginPage;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AccountInformationSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountInformationPage accountInformationPage;

    @Given("user navigates to edit account information page with username {string} and password {string}")
    public void user_navigates_to_edit_account_information_page_with_username_and_password(String username, String password) {
        DriverFactory.getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/login");
        accountInformationPage = new AccountInformationPage(loginPage.performLogin(username, password));
        accountInformationPage.openEditAccountInformationPage();
    }
    @When("user fills the form using given sheet name {string} and row number {int}")
    public void user_fills_the_form_using_given_sheet_name_and_row_number(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testData = excelReader.getData("src/test/resources/TestExcel.xlsx", sheetName);

        String firstname = testData.get(rowNumber).get("First Name");
        String lastname = testData.get(rowNumber).get("Last Name");
        String email = testData.get(rowNumber).get("E-Mail");
        String telephone = testData.get(rowNumber).get("Telephone");

        accountInformationPage.enterPersonalDetails(firstname, lastname, email, telephone);
    }
    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        accountInformationPage.clickContinue();

    }
    @Then("it shows a successful message {string}")
    public void it_shows_a_successful_message(String expectedSuccessMessage) {
        Assert.assertEquals("Success message mismatch", expectedSuccessMessage, accountInformationPage.getSuccessMessage());
    }
    @Then("user log outs from application and lands on {string} page")
    public void user_log_outs_from_application_and_lands_on_page(String expectedPageTitle) {
        accountInformationPage.performMyAccountLogout();
        Assert.assertEquals("Page title mismatch", expectedPageTitle, accountInformationPage.getAccountPageTitle());
    }
}
