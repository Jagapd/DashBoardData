package com.bgp;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    WebDriver driver;

    By loginButton =By.xpath("//*[@id=\"login-button\"]");
    By selectOption=By.name("SAMLart");
    By submitButton=By.xpath("//button[@type='submit']");
    By myGrant=By.xpath("//*[@id=\"grants\"]");

    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    public void clickOnLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public void loginWithPreferredUserId(String userId)
    {
        driver.findElement(selectOption).click();
        new Select(driver.findElement(selectOption)).selectByVisibleText(userId);
        driver.findElement(submitButton).click();
    }

    public void waitForGrantToAppear()
    {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(myGrant));
    }








}
