package com.bitrix.step_definitions;

import com.bitrix.Utilities.BrowserUtils;
import com.bitrix.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
    }
    @After
    public void tearDown() {

        BrowserUtils.waitForSecond(5);
        Driver.closeDriver();


    }
}
