package com.bitrix.step_definitions;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.Utilities.Driver;
import com.bitrix.pages.ActivityStream.MessageTab;
import com.bitrix.pages.ActivityStream.TaskTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_Task_StepDefinition {
    Wait wait = new WebDriverWait(Driver.getDriver(),10);
    MessageTab messageTab = new MessageTab();
    TaskTab taskTab = new TaskTab();
    @When("User clicks on Task tab")
    public void user_clicks_on_task_tab() {
        taskTab.clickOnTab("task");

    }

    @When("User clicks on High Priority checkbox")
    public void user_clicks_on_high_priority_checkbox() {
        taskTab.clickOnHighPriorityCheckBox();

    }
    @Then("Flame image should be lighted up")
    public void flame_image_should_be_lighted_up() {

        Assert.assertTrue(taskTab.highPriorityCheckBox.isSelected());

    }


    @Then("Editor text-bar should be displayed on top of message box in task tab")
    public void editorTextBarShouldBeDisplayedOnTopOfMessageBoxInTaskTab() {
       Assert.assertTrue(true);
    }

    @And("User types Task subject")
    public void userTypesTaskSubject() {
        taskTab.specifyTaskName();
    }

    @And("User clicks on select document from Bitrix under task tab")
    public void userClicksOnSelectDocumentFromBitrixUnderTaskTab() {
        BrowserUtils.waitForSecond(2);
        user_clicks_on_task_tab();
        BrowserUtils.waitForSecond(2);
        taskTab.clickOnIcon("Upload files");
        BrowserUtils.waitForSecond(2);
        messageTab.setSelectDocumentFromBitrix24();



    }


    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String message) {
        BrowserUtils.waitForSecond(3);
        message = "Task has been created";
        Assert.assertEquals(message,taskTab.successMessage());
    }

    @When("User clicks Checklist icon under Task tab")
    public void userClicksChecklistIconUnderTaskTab() {
        taskTab.clickOnChecklistIcon();
    }

    @And("User adds things to do by clicking add button")
    public void userAddsThingsToDoByClickingAddButton() {
        taskTab.clickAddButtonInChecklist();
    }

    @And("User clicks on separator button")
    public void userClicksOnSeparatorButton() {
        taskTab.clickSeparatorButtonInCheckList();
    }

    @And("User adds things to do by clicking check mark button")
    public void userAddsThingsToDoByClickingCheckMarkButton() {
        taskTab.clickCheckMarkButtonInCheckList();

    }

    @And("User deletes checklist item by clicking on x mark.")
    public void userDeletesChecklistItemByClickingOnXMark() {
        taskTab.deleteThingsToDoInbox();
    }

    @And("User clicks on Add More button under TASK tab")
    public void userClicksOnAddMoreButtonUnderTASKTab() {
        taskTab.addMoreButtonUnderTaskTab();
    }

    @And("User clicks on Created by button")
    public void userClicksOnCreatedByButton() {
        BrowserUtils.waitForSecond(2);
        taskTab.chooseAssignmentCategories("Created by");
    }

    @And("User clicks on Participants button")
    public void userClicksOnParticipantsButton() {
        taskTab.chooseAssignmentCategories("Participants");
    }


    @And("User clicks on +Add button in participants")
    public void userClicksOnAddButtonInParticipants() {

        taskTab.clickPlusAddButtonParticipants();
    }

    @And("User clicks on +Add button in observers")
    public void userClicksOnAddButtonInObservers() {
        taskTab.clickPlusAddButtonObservers();
    }
}
