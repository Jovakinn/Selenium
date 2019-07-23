package com.mainacad.service;

import com.mainacad.model.User;
import com.mainacad.util.TimerUtil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PromUserService {

    private static final String BASE_URL = "https://prom.ua";

    public static WebDriver registerUser(User user, WebDriver driver){
        driver.get(BASE_URL);
        TimerUtil.waitSeconds(3);
        String loginUrl = getLoginUrl(driver);

        if (StringUtils.isBlank(loginUrl)){
            return driver;
        }


        driver.get(loginUrl);
        TimerUtil.waitSeconds(3);

        String registerPageUrl = getRegisterPage(driver);
        if (StringUtils.isBlank(registerPageUrl)){
            return driver;
        }

        driver.get(registerPageUrl);
        TimerUtil.waitSeconds(3);

        WebElement registerForm = driver.findElement(By.id("join-now-tabbed-first"));
        List<WebElement> inputElements = registerForm.findElements(By.tagName("input"));
        for (WebElement inputElement: inputElements) {
            if (StringUtils.equals(inputElement.getAttribute("name"), "email")){
                inputElement.sendKeys(user.getLogin());
                TimerUtil.waitSeconds(3);
            }
            if (StringUtils.equals(inputElement.getAttribute("name"), "password")){
                inputElement.sendKeys(user.getPassword());
                TimerUtil.waitSeconds(3);
            }
        }

        WebElement btnElement = registerForm.findElements(By.tagName("button")).get(0);

        if (btnElement != null){
            btnElement.submit();
            TimerUtil.waitSeconds(3);
        }

        String currentUrl = driver.getCurrentUrl();
        driver.get(currentUrl);
        TimerUtil.waitSeconds(3);

        return driver;
    }

    private static String getRegisterPage(WebDriver driver) {
        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        String registerPageUrl = "";
        for (WebElement aElement : aElements) {
            if (StringUtils.endsWith(aElement.getAttribute("class"), "x-start-selling__btn")){
                return aElement.getAttribute("href");
            }
        }
        return registerPageUrl;
    }

    private static String getLoginUrl(WebDriver driver) {
        List<WebElement> aElements = driver.findElements(By.tagName("a"));
        String loginUrl = "";
        for (WebElement aElement : aElements) {
            if (aElement.getAttribute("data-qaid")!=null && aElement.getAttribute("data-qaid").equals("auth_element") ){
                return aElement.getAttribute("href");
            }
        }
        return loginUrl;
    }

    public static WebDriver loginUser(User user, WebDriver driver){


        return driver;
    }

}