package com.mainacad.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ChromeDriverUtil {

    private static final String MAIN_PATH = System.getProperty("user.dir");
    private static final String SEP = System.getProperty("file.separator");


    private static final String DRIVER_PATH = MAIN_PATH + SEP + "driver" + SEP + "chromedriver.exe";

    public static WebDriver getChromeDriver(){

        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

        // ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        TimerUtil.waitSeconds(3);
        return chromeDriver;
    }

    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
