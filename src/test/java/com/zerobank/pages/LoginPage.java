package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "signin_button")
    public WebElement signBtn_loc;

    @FindBy(id = "user_login")
    public WebElement inputUser_loc;

    @FindBy(id = "user_password")
    public WebElement inputPassword_loc;

    @FindBy(name = "submit")
    public WebElement signInBtn_loc;

    @FindBy(xpath = "//li/a[.='Account Summary']")
    public WebElement accountSummaryMessage;

    @FindBy(xpath = "(//form[@id='login_form']/div)[1]")
    public WebElement invalidErrorMessage;

    //div[@class='alert alert-error']

    public void login_mtd(String username, String password){

        //String username = ConfigurationReader.get("username");
        //String password = ConfigurationReader.get("password");

        //loginBtn_loc.click();
        inputUser_loc.sendKeys(username);
        inputPassword_loc.sendKeys(password);
        BrowserUtils.waitFor(1);
        signInBtn_loc.click();
        BrowserUtils.waitFor(2);
        Driver.get().navigate().to(ConfigurationReader.get("url2"));

    }

    public void negativeLogin(String username, String password) {

        inputUser_loc.sendKeys(username);
        inputPassword_loc.sendKeys(password);
        BrowserUtils.waitFor(1);
        signInBtn_loc.click();
        BrowserUtils.waitFor(2);

    }

    public void verifySummaryMessage(String expectedMessage){
        String actualMessage = accountSummaryMessage.getText();
        BrowserUtils.waitFor(2);
        Assert.assertEquals("Verify does match",expectedMessage,actualMessage);
        System.out.println(expectedMessage);
        System.out.println(actualMessage);
        BrowserUtils.waitFor(1);

    }

    public void verifyInvalidMessage(String expectedMessage){
        String actualMessage = invalidErrorMessage.getText();
        BrowserUtils.waitFor(2);
        Assert.assertEquals("Verify does NOT match", expectedMessage,actualMessage);
        BrowserUtils.waitFor(1);
    }
}
