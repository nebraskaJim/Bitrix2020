package com.bitrix.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private Driver() {
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (driver.get() == null) {

            // check the command line argument browser. if it has value, use that value
            // if no browser value is passed from command line, the user properties file
            // mvn test -Dbrowser=remote-chrome
            // mvn test -Dbrowser=remote-firefox
            // mvn test -Dcucumber.filter.tags=@regression -Dbrowser=remote-firefox
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set(new SafariDriver());
                    break;

                case "remote-chrome":
                    try {
                        URL url = new URL("http://18.208.163.204:4444/wd/hub");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        driver.set(new RemoteWebDriver(url, chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox-linux":
                    try {
                        URL url = new URL("http://3.86.148.247:4444/wd/hub");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("platform", Platform.LINUX);
                        driver.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                case "remote-firefox-win":
                    try {
                        URL url = new URL("http://3.86.148.247:4444/wd/hub");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("versopm", "asd");
                        driver.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                case "remote-safari":
                    try {
                        URL url = new URL("http://3.86.148.247:4444/wd/hub");
                        SafariOptions s = new SafariOptions();
                        driver.set(new RemoteWebDriver(url, s));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();

        }
    }

}
