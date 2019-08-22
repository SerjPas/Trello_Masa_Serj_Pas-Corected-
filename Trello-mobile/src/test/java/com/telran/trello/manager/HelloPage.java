package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HelloPage extends HelperBase {
    public HelloPage(AppiumDriver driver) {
        super(driver);
    }

    public String getText() {
        return driver.findElement(By.id("text")).getText();
    }
}
