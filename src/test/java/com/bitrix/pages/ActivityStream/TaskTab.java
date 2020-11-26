package com.bitrix.pages.ActivityStream;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class TaskTab extends BasePage {

    @FindBy(xpath = "//input[@id='tasks-task-priority-cb']")
    public WebElement highPriorityCheckBox;

    @FindBy(xpath = "(//span[@title='Bold']//..)[5]")
    public WebElement editorTextBar;

    @FindBy(xpath = "//div[@class='task-info-panel-title']/input")
    private WebElement taskNameInput;

    @FindBy(xpath = "//div[.='Task has been created']")
    private WebElement taskCreatedMessage;

    @FindBy(xpath = "//span[.='Checklist']")
    private WebElement checklistIcon;

    @FindBy(xpath = "//span[@class='task-checklist-form-vpadding']/input")
    private WebElement thingsToDoInput;

    @FindBy(xpath = "(//span[.='add'])[1]")
    private WebElement addButtonInCheckList;

    @FindBy(xpath = "(//span[.='separator'])[2]")
    private WebElement separatorButtonInCheckList;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")
    private WebElement checkMarkButtonInCheckList;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-close tasks-btn-delete task-field-title-del']")
    private WebElement xMarkButtonInCheckList;




    public void clickOnHighPriorityCheckBox(){
        wait.until(ExpectedConditions.visibilityOf(highPriorityCheckBox));
        if(!highPriorityCheckBox.isSelected()){
            highPriorityCheckBox.click();
        }
    }

    public void specifyTaskName(){
        wait.until(ExpectedConditions.visibilityOf(taskNameInput));
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        taskNameInput.sendKeys("Task "+randomNumber);
    }

    public String successMessage(){
        String message = taskCreatedMessage.getText();
        return message;

    }

    public void clickOnChecklistIcon(){
        BrowserUtils.waitForSecond(3);
        wait.until(ExpectedConditions.elementToBeClickable(checklistIcon));
        checklistIcon.click();
    }

    public void specifyThingsToDo(){
        wait.until(ExpectedConditions.visibilityOf(thingsToDoInput));
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        BrowserUtils.waitForSecond(2);
        thingsToDoInput.sendKeys("Things to do "+randomNumber);
    }

    public void clickAddButtonInChecklist(){
        specifyThingsToDo();
        BrowserUtils.waitForSecond(1);
        wait.until(ExpectedConditions.elementToBeClickable(addButtonInCheckList));
        addButtonInCheckList.click();

    }
    public void clickSeparatorButtonInCheckList(){
        wait.until(ExpectedConditions.elementToBeClickable(separatorButtonInCheckList));
        separatorButtonInCheckList.click();

    }

    public void clickCheckMarkButtonInCheckList(){
        specifyThingsToDo();
        BrowserUtils.waitForSecond(1);
        wait.until(ExpectedConditions.elementToBeClickable(checkMarkButtonInCheckList));
        checkMarkButtonInCheckList.click();

    }

    public void deleteThingsToDoInbox(){
        wait.until(ExpectedConditions.elementToBeClickable(xMarkButtonInCheckList));
        xMarkButtonInCheckList.click();

    }



}
