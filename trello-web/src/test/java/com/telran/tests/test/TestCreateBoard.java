package com.telran.tests.test;

import com.telran.tests.model.Board;
import com.telran.tests.fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCreateBoard extends TestBase {
  @Test
  public void boardCreationTestFromHeader () throws InterruptedException {

int beforeCreation = app.getBoard().getBoardsCount();
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getBoard().selectCreateBoardFromDropDown();
    app.getBoard().fillBoardCreationForm(new Board("Masa2019-" + System.currentTimeMillis() % 100));
    app.getBoard().confirmBoardCreation();
    app.getHeader().clickOnHomeButtonOnHeader();

    int afterCreation= app.getBoard().getBoardsCount();

      System.out.println("Boards before creation: " + beforeCreation + " \n " + "Boards after creation: " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }



}
