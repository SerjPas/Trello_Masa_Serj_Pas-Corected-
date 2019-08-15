package com.telran.tests.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class BaseHelper {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger((BaseHelper.class));

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

    public void takeScreenshot() throws IOException {
        /**
         * записываем во временный файл наш скриншот
         */
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshot = new File("src/test/screenshots/screenshot" + System.currentTimeMillis() + ".png");
        Files.copy(tmp, screenshot);
        logger.info("_____________________________________________________");
        logger.info(" Screenshot name: " + screenshot.getName());
    }
}
