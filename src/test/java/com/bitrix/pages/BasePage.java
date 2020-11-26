package com.bitrix.pages;

import com.bitrix.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public Wait wait = new WebDriverWait(Driver.getDriver(),10);

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    static int num = 0;

    public void navigateTo(String moduleName){

        WebElement modules = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+moduleName+"') and @class='menu-item-link-text']"));
        modules.click();
        wait.until(ExpectedConditions.visibilityOf(modules));
    }
    public void clickOnTab(String tabName){
        if(tabName.equals("message")){
            num=1;
        }else if(tabName.equals("task")){
            num = 3;
        }
        tabName = tabName.substring(0,1).toUpperCase()+tabName.substring(1);
        WebElement tabs = Driver.getDriver().findElement(By.xpath("//div[@class='feed-add-post-form-variants']//span[contains(text(),'"+tabName+"')]"));
        wait.until(ExpectedConditions.visibilityOf(tabs));
        tabs.click();
    }
    ////span[@title='Name: Welcome Scan.jpg']
    public void clickOnIcon(String iconName){


        WebElement icons = Driver.getDriver().findElement(By.xpath("(//span[@title='"+iconName+"'])["+num+"]"));
        wait.until(ExpectedConditions.visibilityOf(icons));
        icons.click();

    }
}
