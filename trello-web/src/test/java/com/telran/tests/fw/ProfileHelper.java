package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class ProfileHelper extends BaseHelper {

    public ProfileHelper(WebDriver driver) {
        super(driver);
    }
    public void moveToImage() {
        WebElement webElement = driver.findElement(By.xpath("//div[@class='rsiNque2CCqtPE']"));
        new Actions(driver).moveToElement(webElement).click().perform();
    }

    public void attachPhotoToProfile(File file) {
        attach(By.xpath("//*[@name='file']"), file);
    }
    public void clickOnProfileAndVisibilityOnHeader() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }
}
