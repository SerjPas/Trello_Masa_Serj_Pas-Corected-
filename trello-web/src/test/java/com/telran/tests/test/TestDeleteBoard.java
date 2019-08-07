package com.telran.tests.test;
import com.telran.tests.fw.TestBase;
import org.testng.annotations.Test;


public class TestDeleteBoard extends TestBase {
//    @BeforeMethod
//    public void precondition() throws InterruptedException {
//        if(app.getBoard().isBoardPresent()){
//            new TestCreateBoard().boardCreationTestFromHeader();
//        }
//    }
    @Test
    public void testBoardDeletion() throws InterruptedException {
        int beforeTestBoardCount = app.getBoard().getBoardsCount();
        app.getSession().pause(2000);
        app.getBoard().clickOnFirstBoard();
        app.getBoard().clickOnMoreMenuButton();
        app.getBoard().clickOnMenuButtonCloseBoard();
        app.getBoard().clickOnSubmitDeleteBoardButton();
        app.getBoard().clickOnPermanentlyDeleteBoardButton();
        app.getBoard().clickOnSubmitDeleteBoardButton();
        app.getHeader().clickOnHomeButtonOnHeader();
        int afterTestBoardCount = app.getBoard().getBoardsCount();
        System.out.println("Boards before deleting: " + beforeTestBoardCount + "\n" + "Boards after deleting: " + afterTestBoardCount);
    }
}
