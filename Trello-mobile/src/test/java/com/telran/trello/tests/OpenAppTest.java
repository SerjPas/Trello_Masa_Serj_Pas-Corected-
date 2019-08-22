package com.telran.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAppTest  extends TestBase{
  @Test
  public void openApp() throws InterruptedException {
    System.out.println("app opened");
    Assert.assertEquals(app.getHelloPage().getText(),"Hello Trello!");

    app.getHelloPage().swipeFromRightToLeft();
    Assert.assertEquals(app.getHelloPage().getText(),"Get organized");
   // Assert.assertTrue();
    app.getHelloPage().swipeFromRightToLeft();
    Assert.assertEquals(app.getHelloPage().getText(),"Add details");
    app.getHelloPage().swipeFromRightToLeft();
    Assert.assertEquals(app.getHelloPage().getText(),"Team up");



  }
}
