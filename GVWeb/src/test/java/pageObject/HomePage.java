package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends Base{

    static String Home="//a[normalize-space()='Home']";

    static  String RecommendationText="//h2[normalize-space()='Recommended']";

    static  String profileImage="//img[@alt='dummy-img']";

    public static SelenideElement getHomeElement() {
        return Selenide.$x(Home);
    }

    public static SelenideElement getRecommendedText() {
        return Selenide.$x(RecommendationText);
    }

    public static SelenideElement getProfileImage() {
        return Selenide.$x(profileImage);
    }








}
