package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateBoardTest  extends  TestBase{
  @Test
  public void boardCreationTestFromHeader () throws InterruptedException {

int beforeCreation = app.getBoard().getBoardsCount();
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getBoard().selectCreateBoardFromDropDown();
    app.getBoard().fillBoardCreationForm("Masa-" + System.currentTimeMillis());
    app.getBoard().confirmBoardCreation();
    app.getHeader().clickOnHomeButtonOnHeader();

    int afterCreation= app.getBoard().getBoardsCount();

    System.out.println(beforeCreation + " : " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }



}
