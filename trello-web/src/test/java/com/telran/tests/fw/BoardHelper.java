package com.telran.tests.fw;

import com.telran.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends BaseHelper {
    public BoardHelper(WebDriver driver) {
        super(driver);
    }
    HeaderPage headerPage = new HeaderPage(driver);

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        //select without team
        click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));

    }

    public void confirmBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
        pause(1000);
    }


    public int getBoardsCount() throws InterruptedException {
        pause(1000);
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 2;
    }

    public boolean isBoardPresent() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
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
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }


    public void clickOnBoardsOnHeader() {
        click(By.xpath("//span[@class='MEu8ZECLGMLeab']"));
    }

    public void cleanBoards() throws InterruptedException {
        int count = getBoardsCount();
        while (count > 3) {
            clickOnFirstBoard();
            clickOnMoreMenuButton();
            clickOnMenuButtonCloseBoard();
            clickOnSubmitDeleteBoardButton();
            clickOnPermanentlyDeleteBoardButton();
            clickOnSubmitDeleteBoardButton();
            headerPage.clickOnHomeButtonOnHeader();
            count = getBoardsCount();
        }
    }
}
