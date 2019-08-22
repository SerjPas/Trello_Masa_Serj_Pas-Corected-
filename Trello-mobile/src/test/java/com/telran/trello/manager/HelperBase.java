package com.telran.trello.manager;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {
  AppiumDriver driver;
  Logger logger = LoggerFactory.getLogger(HelperBase.class);

  public HelperBase(AppiumDriver driver) {
    this.driver = driver;
  }

  public void swipeFromRightToLeft() throws InterruptedException {
    TouchAction touch = new TouchAction(driver);
    Dimension size = driver.manage().window().getSize();

    int y = size.height /2;

    int startX = (int) (size.width *0.8);
    int stopX = (int) (size.width *.02);


    /**
     * нажали - подождали - перетянули - отпустили - выполнили
     */
    touch.longPress(PointOption.point(startX,y)).waitAction()
            .moveTo(PointOption.point(stopX,y)).release().perform();
      pause(1000);

  }


  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void attach(By locator, File file) {
    driver.findElement(locator).sendKeys(file.getAbsolutePath());
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

  public  void takeScreenshot() throws IOException {
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot =
            new File("src/test/screenshots/screenshot-"+ System.currentTimeMillis()+".png");
    Files.copy(tmp, screenshot);
    logger.info("-----------------------------------------------------");
    logger.info("Screenshot name: "+ screenshot.getName());
  }


  public void closeKeyBoard() {
    driver.hideKeyboard();
  }
}
