package pageObject;

import api.IAction;
import api.IValidation;
import com.codeborne.selenide.SelenideElement;

public class Base implements IAction, IValidation {
    @Override
    public void clickOnLoginButton(SelenideElement element) {
        element.click();
    }
}
