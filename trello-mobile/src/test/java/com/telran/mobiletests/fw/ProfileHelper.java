package com.telran.mobiletests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class ProfileHelper extends BaseHelper {

    public ProfileHelper(WebDriver driver) {
        super(driver);
    }
    public void moveToImage(){
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(
                "[class='MrFeHFqEkuBP9W _1h1BubYfUOs6MB']"))).pause(2).click().perform();
    }

    public void attachPhotoToProfile(File file) throws InterruptedException {
        attach(By.xpath("//*[@name='file']"), file);
        pause(2000);
    }
    public void clickOnProfileAndVisibilityOnHeader() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }
}
