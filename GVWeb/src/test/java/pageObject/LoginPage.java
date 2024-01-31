package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    static String emailBox="//input[@id='email']";

    static String unverifiedUserMessage="//span[normalize-space()='User does not exist']";

    static String emptyPasswordMessage="//*[contains(text(),'This field is required !!')]";

    static String incorrectPasswordMessage="//span[normalize-space()='Invalid password!']";
     static String passwordBox="//input[@id='password']";

    static String loginButton="//button[@type='submit']";

    static String signupButton="//a[normalize-space()='Sign Up']";


    static String agreeTermsCondition="//input[@id='agreement']";

    static String signupPageSignupButton="//span[normalize-space()='Sign Up']";


    static String emailVerificationPage="//h2[normalize-space()='Please verify your account']";

    public static SelenideElement getEmailBox() {
        return Selenide.$x(emailBox);
    }

    public static SelenideElement getPasswordBox() {
        return Selenide.$x(passwordBox);
    }

    public static SelenideElement getUnverifiedUserMessage() {
        return Selenide.$x(unverifiedUserMessage);
    }



    public static SelenideElement getLoginButton() {
        return Selenide.$x(loginButton);
    }
    public static SelenideElement getIncorrectPasswordMessage() {
        return Selenide.$x(incorrectPasswordMessage);
    }

    public static SelenideElement getEmptyPasswordMessage() {
        return Selenide.$x(emptyPasswordMessage);
    }

    public static SelenideElement getLoginPageSignupButton() {
        return Selenide.$x(signupButton);
    }

    public static SelenideElement getSignupPageSignupButton() {
        return Selenide.$x(signupPageSignupButton);
    }

    public static SelenideElement getAgreementBox() {
        return Selenide.$x(agreeTermsCondition);
    }

    public static SelenideElement getEmailVerificationPageText() {
        return Selenide.$x(emailVerificationPage);
    }




}
