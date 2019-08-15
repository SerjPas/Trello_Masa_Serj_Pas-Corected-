package com.telran.mobiletests.test;

import com.telran.mobiletests.fw.TestBase;
import com.telran.mobiletests.model.Board;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class TestCreateBoard extends TestBase {

    @Test
    public void boardCreationTestFromHeader() throws InterruptedException {

        int beforeCreation = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardCreationForm(new Board().setBoardName("Masa2019-" + System.currentTimeMillis() % 100));
        app.getBoard().confirmBoardCreation();
        app.getHeader().clickOnHomeButtonOnHeader();

        int afterCreation = app.getBoard().getBoardsCount();

        System.out.println("Boards before creation: " + beforeCreation + " \n " + "Boards after creation: " + afterCreation);

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }

    @AfterClass
    public void postAction() throws InterruptedException {
        app.getBoard().cleanBoards();
    }
}
