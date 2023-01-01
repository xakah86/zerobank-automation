package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;

import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.signBtn_loc.click();
        BrowserUtils.waitFor(1);
    }
//
//    @When("The user enters valid credentials")
//    public void theUserEntersValidCredentials() {
//        loginPage.login_mtd();
//    }

    @When("The user enters with {string} and {string} credentials")
    public void the_user_enters_with_and_credentials(String username, String password) {
        loginPage.login_mtd(username,password);
    }
    @Then("verify valid credential {string}")
    public void verify_valid_credential(String expectedMessage) {
        loginPage.verifySummaryMessage(expectedMessage);
    }

    @Then("verify invalid credential {string}")
    public void verifyInvalidCredential(String expectedMessage) {
        loginPage.verifyInvalidMessage(expectedMessage);
    }

    @When("The user enters invalid {string} and {string} credentials")
    public void theUserEntersInvalidAndCredentials(String username, String password) {

        loginPage.negativeLogin(username, password);
    }
}
