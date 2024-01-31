package impl;
import api.DriverFactoryApi;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class DriverFactory implements DriverFactoryApi {
    WebDriver driver;

    @Override
    public WebDriver createDriver(String driverName, String baseUrl) {
        switch (driverName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case "firefox":
                FirefoxOptions option = new FirefoxOptions();
                option.addArguments("");
                driver = new FirefoxDriver(option);
                driver.manage().window().maximize();

                break;
        }
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebDriverRunner.setWebDriver(driver);
        return driver;
    }

}
