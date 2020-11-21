package com.bitrix.pages;

import com.bitrix.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    Wait wait = new WebDriverWait(Driver.getDriver(),10);
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void navigateTo(String moduleName){

        WebElement modules = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+moduleName+"') and @class='menu-item-link-text']"));
        modules.click();
        wait.until(ExpectedConditions.visibilityOf(modules));
    }
}
