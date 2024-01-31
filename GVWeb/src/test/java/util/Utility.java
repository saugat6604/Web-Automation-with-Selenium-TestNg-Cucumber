package util;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.json.JSONObject;



public class Utility {
    static Properties props;
    public WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }


    public static Properties property() {
        props = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/automationConfigQA.properties"));
            props.load(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public String getUrl() {
        return property().getProperty("baseUrl");
    }

    public static String getUsername() {
        return property().getProperty("userName");
    }

    public String getBrowser() {
        return property().getProperty("browserName");
    }

    public static String getPassword() {
        return property().getProperty("password");
    }

    public String getWrongPassword() {
        return property().getProperty("wrongPassword");
    }

    public String getForgotPasswordUrl() {
        return property().getProperty("forgotPasswordUrl");
    }


    public static String generateRandomText() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000); // Generate a random number between 0 and 99
        String prefix = "sam";
        String postfix = "@clickandpress.com";
        String result = prefix + randomNumber + postfix;
        return result;
    }

    public static String verifyUser(String emails) {
        System.out.println(emails);
        RestAssured.baseURI = "https://api-qa.goodvibesofficial.com/api/goodvibes/graphql";
        JSONObject requestParams = new JSONObject();
        requestParams.put("query", String.format("{validatePaymentSubscription(email:\"%s\",firstName:\"sauggg\",lastName:\"happ\",password:\"Hetauda@1\",subscriptionOffer:{name:\"sssf\"})\n}", emails));
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestParams.toString())
                .post();
        System.out.println(response.getBody().asString());
        String messages = response.jsonPath().getString("data.validatePaymentSubscription");
        System.out.println(messages);
        return  messages;

    }

    }







