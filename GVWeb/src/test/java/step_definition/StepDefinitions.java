package step_definition;


import com.codeborne.selenide.Condition;
import impl.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import util.Utility;

import java.util.HashMap;
import java.util.Map;


public class StepDefinitions {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static Utility util;
    static Map<String, Object> data = new HashMap<>();

    @Given("GV Web application is open")
    public static void openApplication() {
        util = new Utility(driver);
        driver = new DriverFactory().createDriver(util.getBrowser(), util.getUrl());
        loginPage = new LoginPage();
    }

    @And("user verifies Login page")
    public void verifyLoginPage() {
        Assert.assertEquals(util.getUrl(), "https://my-qa.goodvibesofficial.com/login");
    }


    @And("^user enters  (.*) and  (.*)")
    public static void enterCredentials(String username, String password) throws InterruptedException {
        String uname = null;
        switch (username) {
            case "correct username":
                uname = Utility.getUsername();
                break;
            case "incorrect username":
                uname = "hawa@gmail.com";
                break;
            case "invalid email":
                uname = "saugat@clickandpress";
                break;
            case "empty username":
                uname="";
            case "unverified username":
                uname="saugatinkkkk@gmail.com";
                break;
            case "new username":
                uname=Utility.generateRandomText();
                break;
            case "previously registered":
                uname = (String) data.get("email");
            break;
            default:
                System.out.println("username not found");
                break;
        }
        String pass = null;
        switch (password) {
            case "correct password":
                pass = Utility.getPassword();
                break;
            case "incorrect password":
                pass = "Kathmandu@12345";
                break;
            case "strong password":
                pass = "Kathmandu@123";
                break;
            case "empty password":
                pass="";
                break;
            default:
                System.out.println("password not found");
                break;
        }
        LoginPage.getEmailBox().sendKeys(uname);
        LoginPage.getPasswordBox().sendKeys(pass);
    }

    @And("user enter valid email and password")
    public void userEnterValidEmailAndPassword() {
        //LoginPage.getEmailBox().sendKeys("krishna@clickandpress.com");
        LoginPage.getEmailBox().sendKeys(util.getUsername());
        LoginPage.getPasswordBox().sendKeys(util.getPassword());
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        LoginPage.getLoginButton().click();
    }

    @Then("user verifies Homepage")
    public void userVerifiesHomepage() {
        HomePage.getHomeElement().shouldBe(Condition.visible);
        HomePage.getProfileImage().shouldBe(Condition.visible);
    }

    @Then("^user verifies (.*) validation messages")
    public void userVerfiesValidationMessage(String message) throws InterruptedException {
        switch (message) {
            case "incorrect password":
                LoginPage.getIncorrectPasswordMessage().isDisplayed();
                break;
            case "empty password":
                LoginPage.getEmptyPasswordMessage().isDisplayed();
                break;
            case "unverified user":
                LoginPage.getUnverifiedUserMessage().isDisplayed();
                break;

            default:
                System.out.println("no any message");
        }
    }

    @And("user clicks on signup button of Login page")
    public void userClicksOnSignupButton() {
        LoginPage.getLoginPageSignupButton().click();
    }

    @And("user clicks on signup button of Signup page")
    public void userClicksOnSignupButtonOfSignupPage() {
        LoginPage.getSignupPageSignupButton().click();
    }

    @And("user confirms terms and condition")
    public void userConfirmsTermsAndCondition() {
        LoginPage. getAgreementBox().click();
    }

    @Then("user verifies email verification page")
    public void userVerifiesEmailVerificationPage() {
        LoginPage.getEmailVerificationPageText().isDisplayed();
    }

    @And("user verifies email from backend")
    public void userVerifiesEmailFromBackend() {
        String uname = Utility.generateRandomText();
        if (!(data.get("email") == null)) {
            data.remove("email");
        }
        data.put("email", uname);
        Utility.verifyUser( (String) data.get("email"));

    }

    @And("user go to Login page")
    public void userGoToLoginPage() {
        driver.get(util.getUrl());
    }
}

