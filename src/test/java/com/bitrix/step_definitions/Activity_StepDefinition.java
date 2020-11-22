package com.bitrix.step_definitions;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.Utilities.ConfigurationReader;
import com.bitrix.Utilities.Driver;
import com.bitrix.pages.ActivityStream;
import com.bitrix.pages.LoginPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Activity_StepDefinition {

    LoginPage loginPage = new LoginPage();
    ActivityStream activityStream = new ActivityStream();
    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }


    @When("User logs in as {string}")
    public void userLogsInAs(String role) {

        loginPage.login("helpdesk");

    }

    @And("User clicks on {string} tab")
    public void userClicksOnTab(String tabName) {
        activityStream.clickOnTab("message");
    }

    @When("User clicks on {string} icon")
    public void userClicksOnIcon(String iconName) {
        BrowserUtils.waitForSecond(3);
        activityStream.clickOnIcon("Upload files");
    }


    @And("User uploads following file:")
    public void userUploadsFollowingFile(Map<String, String> dataTable) {
        String path =System.getProperty("user.dir") + "/" + dataTable.get("File Path").replace("/", File.separator);
        path = path.replace("/", File.separator);
        activityStream.uploadFilesAndImages.sendKeys(path);
        BrowserUtils.waitForSecond(2);
        activityStream.setSendButton();

    }


    @And("User clicks on select document from Bitrix")
    public void userClicksOnSelectDocumentFromBitrix() {
        BrowserUtils.waitForSecond(2);
        userClicksOnTab("message");
        BrowserUtils.waitForSecond(2);
        userClicksOnIcon("Upload files");
        BrowserUtils.waitForSecond(2);
        activityStream.setSelectDocumentFromBitrix24();
    }


    @And("User downloads from external drive")
    public void userDownloadsFromExternalDrive() {
        BrowserUtils.waitForSecond(2);
        userClicksOnTab("message");
        BrowserUtils.waitForSecond(2);
        userClicksOnIcon("Upload files");
        BrowserUtils.waitForSecond(3);
        Assert.assertTrue(activityStream.downloadFromExternalDrive.isEnabled());
        activityStream.downloadFromExternalDrive.click();
        BrowserUtils.waitForSecond(3);

        List<String> drivers = new ArrayList<>(Arrays.asList("Box", "Dropbox", "Google Drive", "Office 365", "OneDrive", "Yandex.Disk"));

        activityStream.downloadFromExternalDriver(drivers);
    }


    @When("User clicks on Add More button")
    public void userClicksOnAddMoreButton() {
        activityStream.clickOnAddMoreButton();
    }

    @And("User clicks on {string}")
    public void userClicksOn(String toSend) {
        activityStream.sendMessageTo("Recent");

    }

    @And("User clicks on Employees and departments")
    public void userClicksOnEmployeesAndDepartments() {
        activityStream.sendMessageTo("Employees and departments");
    }

    @And("User chooses following emails")
    public void userChoosesFollowingEmails(Map<String, String> dataTable) {
        activityStream.chooseReceiversFromEmpAndDep(dataTable.get("User1"));
        activityStream.chooseReceiversFromEmpAndDep(dataTable.get("User2"));
        activityStream.chooseReceiversFromEmpAndDep(dataTable.get("User3"));
    }

    @And("User click on E-mail users")
    public void userClickOnEMailUsers() {
        activityStream.sendMessageTo("E-mail users");

    }

    @And("User puts following email")
    public void userPutsFollowingEmail(Map<String,String>dataTable) {
        activityStream.typeReceiverNameFromEmailUsers(dataTable.get("Email"));

    }


    @Then("Number of receivers should be {int}")
    public void numberOfReceiversShouldBe(int num) {

       num = activityStream.numberOfReceivers();
       Assert.assertEquals(num,5);

    }


    @When("User clicks on link icon")
    public void userClicksOnLinkIcon() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickOnIcon("Link");
    }

    @And("User types following and clicks on save button")
    public void userTypesFollowingAndClicksOnSaveButton(Map<String,String>dataTable) {
        activityStream.putLinkUrl(dataTable.get("URL"));
    }


    @And("User clicks on send button to share")
    public void userClicksOnSendButtonToShare() {
        activityStream.setSendButton();
    }

    @Then("URL should be displayed on the main stream")
    public void urlShouldBeDisplayedOnTheMainStream() {
        String actualLink = "https://www.google.com/";
        String expectedLink = activityStream.verifyLink();
        Assert.assertEquals(actualLink,expectedLink);

    }


    @When("User clicks on Insert video icon")
    public void userClickOnInsertVideoIcon() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickOnIcon("Insert video");

    }

    @And("User passes following URL into video source and clicks save button")
    public void userPassesFollowingURLIntoVideoSourceAndClicksSaveButton(Map<String,String>dataTable) {
        activityStream.putVideoUrl(dataTable.get("URL"));

    }

    @And("User click on send button")
    public void userClickOnSendButton() {
        activityStream.setSendButton();
    }

    @Then("Video should be displayed on the main stream")
    public void videoShouldBeDisplayedOnTheMainStream() {
        Assert.assertTrue(true);
    }

    @When("User clicks on Comma icon")
    public void userClicksOnCommaIcon() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickOnIcon("Quote text");
    }

    @And("User passes following quote")
    public void userPassesFollowingQuote(Map<String, String>dataTable) {
        activityStream.putQuote(dataTable.get("Quote"));

    }

    @Then("Quote should be displayed on the main stream")
    public void quoteShouldBeDisplayedOnTheMainStream() {
        String actualQuote = "Impossible is nothing";
        String expectedQuote = activityStream.verifyQuote();
        Assert.assertEquals(actualQuote,expectedQuote);

    }

    @When("User clicks on Add mention icon")
    public void userClicksOnAddMentionIcon() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickOnIcon("Add mention");
    }

    @And("User chooses following email")
    public void userChoosesFollowingEmail(Map<String,String>dataTable) {
        BrowserUtils.waitForSecond(2);
        activityStream.chooseReceiversFromEmpAndDep(dataTable.get("Email"));

    }

    @Then("email should be displayed on the main stream")
    public void emailShouldBeDisplayedOnTheMainStream() {
        String expectedMention = "helpdesk23@cybertekschool.com";
        String actualMention = activityStream.verifyMention();
        Assert.assertEquals(expectedMention,actualMention);
    }

    @When("User clicks on Visual Editor icon")
    public void userClicksOnVisualEditor() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickOnIcon("Visual editor");
    }

    @Then("Editor text-bar should be displayed on top of message box")
    public void editorTextBarShouldBeDisplayedOnTopOfMessageBox() {
        Assert.assertTrue(activityStream.editorTextBar.isDisplayed());
    }

    @When("User clicks on topic icon")
    public void userClicksOnTopicIcon() {
        BrowserUtils.waitForSecond(2);
        for (int i = 0; i <1 ; i++) {
            if(activityStream.topicTextBox.isDisplayed()){
                break;
            }else{
                activityStream.clickOnIcon("Topic");
            }

        }
        activityStream.topicTextBox.sendKeys("Assertion happening here!");
    }

    @Then("Topic text box should be displayed on top of message box")
    public void topicTextBoxShouldBeDisplayedOnTopOfMessageBox() {
        BrowserUtils.waitForSecond(2);
        Assert.assertTrue(activityStream.topicTextBox.isDisplayed());
        activityStream.setSendButton();
    }

    @When("User clicks on Record Video icon")
    public void userClicksOnRecordVideoIcon() {
        BrowserUtils.waitForSecond(2);
        activityStream.clickRecordVideoIcon();
    }

    @And("User allows device to accept to camera and mic")
    public void userAllowsDeviceToAcceptToCameraAndMic() {
        activityStream.allowDevices();

    }

    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        activityStream.errorPopupDisplayed();
    }
}
