package com.bitrix.pages.ActivityStream;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.Utilities.Driver;
import com.bitrix.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MoreTab extends BasePage {

    @FindBy(xpath = "(//a[.='Close'])[2]")
    private WebElement closeButtonUnderInWorkFlow;

    @FindBy(xpath = "(//input[@class='bx-lists-input-calendar'])[1]")
    private WebElement calendarStarDayInput;

    @FindBy(xpath = "(//input[@class='bx-lists-input-calendar'])[2]")
    private WebElement calendarEndDayInput;

    @FindBy(name = "PREVIEW_TEXT")
    private WebElement reasonForLeaveInputText;

    @FindBy(xpath = "//div[@class='bx-lists-block-errors']")
    private WebElement errorMessage;

    /**
     * Tasks; File, Appreciation, Announcement, Workflow
     */
    public void tasksUnderMoreTab(String task){
        WebElement tasksUnderMore = Driver.getDriver().findElement(By.xpath("(//div[@class='menu-popup-items']//span[.='"+task+"'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(tasksUnderMore));
        tasksUnderMore.click();

   }

   public void tasksUnderWorkFlow(String task){
        WebElement taskUnderWorkFlow = Driver.getDriver().findElement(By.xpath("(//div[@class='menu-popup-items']//span[.='"+task+"'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(taskUnderWorkFlow));
        BrowserUtils.waitForSecond(2);
        taskUnderWorkFlow.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeButtonUnderInWorkFlow));
        closeButtonUnderInWorkFlow.click();

   }

   public void calendarStartDate(int month,int day, int year){
        wait.until(ExpectedConditions.visibilityOf(calendarStarDayInput));
        calendarStarDayInput.sendKeys(month+"/"+day+"/"+year);

   }

    public void calendarEndDate(int month,int day, int year){
        wait.until(ExpectedConditions.visibilityOf(calendarEndDayInput));
        calendarEndDayInput.sendKeys(month+"/"+day+"/"+year);

    }

    public void absenceType(String type){
        WebElement absenceDropDown = Driver.getDriver().findElement(By.xpath("//select[@name='PROPERTY_88']"));
        Select absence  = new Select(absenceDropDown);
        absence.selectByVisibleText(type);

    }

    public void reasonForLeaveInput(String input){
        reasonForLeaveInputText.sendKeys(input);


    }

    public String errorMessage(){
        String message  = errorMessage.getText();
        return message;
    }



}
