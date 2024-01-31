package api;

import org.openqa.selenium.WebDriver;

public interface DriverFactoryApi {
    WebDriver createDriver(String driverName,String baseUrl);

}
