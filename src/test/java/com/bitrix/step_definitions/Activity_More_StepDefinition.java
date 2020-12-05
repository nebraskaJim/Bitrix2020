package com.bitrix.step_definitions;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.pages.ActivityStream.MoreTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Activity_More_StepDefinition {

    MoreTab moreTab = new MoreTab();

    @And("User clicks on More tab")
    public void userClicksOnMoreTab() {
        moreTab.clickOnTab("More");
    }


    @When("User clicks on WorkFlow")
    public void userClicksOnWorkFlow() {
        BrowserUtils.waitForSecond(2);
        moreTab.tasksUnderMoreTab("Workflow");
    }

    @And("User clicks on Leave Approval and clicks on close button")
    public void userClicksOnLeaveApprovalAndClicksOnCloseButton() {
        BrowserUtils.waitForSecond(2);
        moreTab.tasksUnderWorkFlow("Leave Approval");
    }

    @And("User selects Start Date and End Date")
    public void userSelectsStartDateAndEndDate() {
        BrowserUtils.waitForSecond(1);
        moreTab.calendarStartDate(10,11,2020);
        BrowserUtils.waitForSecond(1);
        moreTab.calendarEndDate(11,11,2020);
    }

    @And("User selects Absence Type")
    public void userSelectsAbsenceType() {
        BrowserUtils.waitForSecond(1);
        moreTab.absenceType("Business trip");
    }

    @And("User states Reason for Leave")
    public void userStatesReasonForLeave() {
        moreTab.reasonForLeaveInput("Yearly Vacation");
    }

    @Then("Error message below should be displayed")
    public void errorMessageBelowShouldBeDisplayed(Map<String,String> dataTable) {
        BrowserUtils.waitForSecond(2);
        String actual = moreTab.errorMessage();
        String expected = dataTable.get("message");

        Assert.assertEquals(expected,actual);

    }
}
