package com.trendyol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginBtn = By.xpath("//button[@type='submit']");
    By emailText = By.id("login-email");
    By passWordTesxt = By.id("login-password-input");
    By errorMessage = By.xpath("//div//span[@class='message']");


    public LoginPage loginToTrendyol(String email, String password) {
        writeText(emailText, email);
        writeText(passWordTesxt, password);
        click(loginBtn);
        return this;
    }


    public LoginPage verifyLogin(String expectedText) {
        assertEquals(getErrorMessage(), expectedText);
        return this;
    }


    public void verifyLoginSuccessful(String expectedUrl) {
        waitForUrl(expectedUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }


    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


}

