package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper  extends  HelperBase{
  public BoardHelper(WebDriver driver) {
    super(driver);
  }

  public void confirmBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
        pause(15000);
  }

  public void fillBoardCreationForm(String boardName)  {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
  click(By.cssSelector("button.W6rMLOx8U0MrPx"));

  //select without team
   click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));

  }

  public void selectCreateBoardFromDropDown() {
    click(By.xpath("//*[@data-test-id='header-create-board-button']"));
  }

  public int getBoardsCount() throws InterruptedException {
    pause(15000);
    return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-2;
  }
}
