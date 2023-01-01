package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayBills_StepDefs {

    DashboardPage dashboardPage = new DashboardPage();

    @When("The user enters the credentials {string} {string} and click pay button")
    public void the_user_enters_the_credentials_and_click_pay_button(String string, String string2) {
        dashboardPage.payBillsAmountDate();
    }
    @Then("The user verify the dashboard {string}")
    public void the_user_verify_the_dashboard(String expected) {
        dashboardPage.verifyPaySuccesful(expected);
    }

    @When("The user enters invalid credentials {string} {string} and click pay button")
    public void the_user_enters_invalid_credentials_and_click_pay_button(String amount, String date) {
        dashboardPage.invalidCredentialDate(amount, date);
    }
    @Then("The user verify {string}")
    public void the_user_verify(String string) {

    }
}
