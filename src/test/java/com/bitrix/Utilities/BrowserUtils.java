package com.bitrix.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
    private static JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    public static void waitForSecond(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void scroll(WebElement target){

        js.executeScript("arguments[0].scrollIntoView( true);",target);

    }




}
