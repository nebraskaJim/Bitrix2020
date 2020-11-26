package com.bitrix.pages.ActivityStream;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.Utilities.Driver;
import com.bitrix.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageTab extends BasePage {
    Wait wait = new WebDriverWait(Driver.getDriver(),10);

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();


    @FindBy(name = "bxu_files[]")
    public WebElement uploadFilesAndImages;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath="//span[.='Select document from Bitrix24']")
    private WebElement selectDocumentFromBitrix24;

    @FindBy(xpath = "//div[contains(@onclick,'return')]")
    private List<WebElement>targetImages;

    @FindBy(xpath = "//span[.='Select document']")
    private WebElement selectButtonForTargetImage;

    @FindBy(xpath = "(//span[.='More' and @class='feed-post-more-text'])[1]")
    private WebElement moreButton;

    @FindBy(xpath = "//span[.='Download from external drive']")
    public WebElement downloadFromExternalDrive;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButtonForSelectDocument;

    @FindBy(xpath = "//a[.='Add more']")
    private WebElement addMoreButton;

    @FindBy(xpath = "//input[contains(@type,'text') and @id='feed-add-post-destination-input']")
    private WebElement textInputForEmailUsers;

    @FindBy(xpath = "//span[@id='feed-add-post-destination-item']/span")
    private List<WebElement>numOfReceivers;

    @FindBy(xpath = "//input[@placeholder='Link URL']")
    private WebElement linkURLInput;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveButtonForIconActions;

    @FindBy(xpath = "(//a[.='https://www.google.com/'])[1]")
    private WebElement link;

    @FindBy(xpath = "//tbody/tr/td/input[@id='video_idPostFormLHE_blogPostForm-source']")
    private WebElement videoSourceInput;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement iframeForQuote;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    private WebElement quoteInput;

    @FindBy(xpath = "//table[@class='blogquote']/tbody/tr/td")
    private WebElement quote;

    @FindBy(xpath = "//a[@class='blog-p-user-name']/following-sibling::a" )
    private WebElement mention;

    @FindBy(xpath = "(//span[@title='Bold']//..)[1]")
    public WebElement editorTextBar;

    @FindBy(id = "POST_TITLE")
    public WebElement topicTextBox;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-blue']")
    private WebElement allowDeviceAccess;

    @FindBy(xpath = "//div[@id='bx-popup-videomessage-popup']")
    private WebElement errorPopup;

    @FindBy(xpath = "(//span[.='Record Video'])[1]")
    private WebElement recordVideoIcon;










    public void clickRecordVideoIcon(){
        recordVideoIcon.click();
    }

    public void setUploadFilesAndImages(String filePath){

        BrowserUtils.waitForSecond(2);
        wait.until(ExpectedConditions.visibilityOf(uploadFilesAndImages));
        //filePath = System.getProperty("user.dir")+"/"+filePath.replace("/", File.separator);
        uploadFilesAndImages.click();
//        BrowserUtils.waitForSecond(2);
//        uploadFilesAndImages.sendKeys(filePath);
//        BrowserUtils.waitForSecond(2);

    }

    public void setSendButton(){
        BrowserUtils.waitForSecond(2);
        sendButton.click();
    }
    public void deleteAfterUploading(){

    }




    public void setSelectDocumentFromBitrix24(){
        wait.until(ExpectedConditions.elementToBeClickable(selectDocumentFromBitrix24));
        selectDocumentFromBitrix24.click();
        BrowserUtils.waitForSecond(2);
        int size = targetImages.size();
         WebElement targetImages2 = Driver.getDriver().findElement(By.xpath("(//div[contains(@onclick,'return')])["+size+"]"));

        javascriptExecutor.executeScript("arguments[0].scrollIntoView( true);",targetImages2);
        BrowserUtils.waitForSecond(1);
        targetImages2.click();
        selectButtonForTargetImage.click();
        sendButtonForSelectDocument.click();


    }

    public void downloadFromExternalDriver(List<String>drivers){
        //List<String> drivers = new ArrayList<>(Arrays.asList("Box", "Dropbox", "Google Drive", "Office 365", "OneDrive", "Yandex.Disk"));


        for (String each : drivers) {
            WebElement externalDriver = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+each+"') and @title='"+each+"']"));

            externalDriver.isDisplayed();
            externalDriver.click();
            BrowserUtils.waitForSecond(1);
        }
    }

    public void clickOnAddMoreButton(){
       wait.until(ExpectedConditions.elementToBeClickable(addMoreButton));
       addMoreButton.click();

    }
    public void sendMessageTo(String receiver){
        BrowserUtils.waitForSecond(2);
        WebElement receivers = Driver.getDriver().findElement(By.xpath("//a[.='"+receiver+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(receivers));
        receivers.click();

    }

    public void chooseReceiversFromEmpAndDep(String email){
        BrowserUtils.waitForSecond(1);
        WebElement receiverEmail =
                Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+email+"') and @class='bx-finder-company-department-employee-name']"));
        wait.until(ExpectedConditions.elementToBeClickable(receiverEmail));
        receiverEmail.click();

    }
    public void typeReceiverNameFromEmailUsers(String email){
        BrowserUtils.waitForSecond(2);
        wait.until(ExpectedConditions.elementToBeClickable(textInputForEmailUsers));
        textInputForEmailUsers.sendKeys(email, Keys.ENTER);
    }

    public int numberOfReceivers(){
        BrowserUtils.waitForSecond(2);
        int num = numOfReceivers.size();
        return num;
    }

    public void putLinkUrl(String link){
        wait.until(ExpectedConditions.visibilityOf(linkURLInput));
        linkURLInput.sendKeys(link);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonForIconActions));
        saveButtonForIconActions.click();

    }

    public String verifyLink(){
        BrowserUtils.waitForSecond(3);
        String linkCheck  = link.getText();
        return linkCheck;
    }

    public void putVideoUrl(String link){
        wait.until(ExpectedConditions.visibilityOf(videoSourceInput));
        videoSourceInput.sendKeys(link);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonForIconActions));
        BrowserUtils.waitForSecond(4);
        saveButtonForIconActions.click();

    }

    public void putQuote(String quote){
        Driver.getDriver().switchTo().frame(iframeForQuote);
        BrowserUtils.waitForSecond(1);
        quoteInput.sendKeys(quote);
        Driver.getDriver().switchTo().defaultContent();

    }

    public String verifyQuote(){
        BrowserUtils.waitForSecond(3);
        String quotes = quote.getText();
        return quotes;
    }

    public String verifyMention(){
        BrowserUtils.waitForSecond(2);
        String mentions = mention.getText();
        return mentions;

    }


    public void allowDevices(){
        allowDeviceAccess.click();
        BrowserUtils.waitForSecond(3);
    }

    public void errorPopupDisplayed(){
        errorPopup.isDisplayed();
    }









}
