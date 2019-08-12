package com.telran.tests.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

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

    public void takeScreenShot() throws IOException {
        /**
         * записываем во временный файл наш скриншот
         */
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenShot = new File("src/test/screenshots/screenshot" + System.currentTimeMillis() % 1000 + ".png");
        Files.copy(tmp, screenShot);
        System.out.println(" Screenshot name: " + screenShot.getName());
    }
}
