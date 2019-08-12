package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SessionHelper extends BaseHelper {


    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        clickOnLoginButton();
        fillUserForm(email, password);
        confirmLoginButton();
        pause(1000);
    }

    public boolean isUserLoggedIn() {
        return isElementsPresent(By.cssSelector(".js-open-header-member-menu"));
    }

    public void confirmLoginButton() {
        click(By.id("login"));
    }

    public void fillUserForm(String email, String password) {
        type(By.id("user"), email);
        type(By.id("password"), password);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void logout() {
        if (isUserLoggedIn()) {
            clickOnAvatar();
            clickLogout();
        }
    }

    public void clickLogout() {
        click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector(".js-open-header-member-menu"));
    }


}
