package com.bitrix.pages;

import com.bitrix.Utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public void login(){

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }

    public void login(String role){

        role = role.toLowerCase();
        String username = ConfigurationReader.getProperty("email."+role);
        String password = ConfigurationReader.getProperty("password");

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }



}
