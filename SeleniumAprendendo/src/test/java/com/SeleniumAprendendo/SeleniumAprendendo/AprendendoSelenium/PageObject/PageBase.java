package com.SeleniumAprendendo.SeleniumAprendendo.AprendendoSelenium.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PageBase {
    static WebDriver driver;

    public PageBase(WebDriver driver) {
        PageBase.driver = driver;
    }

    public PageBase() {
        System.setProperty("webdriver.chrome.driver","C:/ArquivosProgramaJava/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
    }

    public void navegateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void closeNavegator() {
        getDriver().close();
    }
}

