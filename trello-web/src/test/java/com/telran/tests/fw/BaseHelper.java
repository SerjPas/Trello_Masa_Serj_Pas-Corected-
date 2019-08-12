package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void attach(By locator, File file) {
        driver.findElement(locator).sendKeys(file.getAbsolutePath()); //передаем адрес нашего файла
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


}
