package com.mainacad;

import com.mainacad.model.User;
import com.mainacad.service.PromUserService;
import com.mainacad.util.ChromeDriverUtil;
import org.openqa.selenium.WebDriver;

public class App {

    public static void main( String[] args ) {
        WebDriver driver = ChromeDriverUtil.getChromeDriver();

        User user = new User("testUser5574723@gmail.com", "1234567", "Max", "Khodakov");
        driver = PromUserService.registerUser(user, driver);

        ChromeDriverUtil.quitDriver(driver);
    }
}
