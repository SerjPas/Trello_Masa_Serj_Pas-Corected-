package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends BaseHelper {
    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(String boardName) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        //select without team
        click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));

    }

    public void confirmBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
        pause(15000);
    }


    public int getBoardsCount() throws InterruptedException {
        pause(1000);
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 2;
    }

    public boolean isBoardPresent() {
        return isElementPresent(By.xpath(""));
    }
    public void clickOnPermanentlyDeleteBoardButton() {
        click(By.xpath("//a[@class='quiet js-delete']"));
    }

    public void clickOnSubmitDeleteBoardButton() {
        click(By.xpath("//input[@class='js-confirm full negate']"));
    }

    public void clickOnMenuButtonCloseBoard() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnMoreMenuButton() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickOnFirstBoard() {
        click(By.xpath("//div[@class='all-boards']//div[2]//ul[1]//li[1]"));
    }


    public void clickOnBoardsOnHeader() {
        click(By.xpath("//span[@class='MEu8ZECLGMLeab']"));
    }
}
