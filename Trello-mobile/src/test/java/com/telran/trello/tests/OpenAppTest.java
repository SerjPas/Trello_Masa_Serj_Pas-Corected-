package com.telran.trello.tests;

import org.testng.annotations.Test;

public class OpenAppTest  extends TestBase{
  @Test
  public void openApp() throws InterruptedException {
    System.out.println("app opened");

    app.getHelloPage().swipeFromRightToLeft();
    app.getHelloPage().swipeFromRightToLeft();
    app.getHelloPage().swipeFromRightToLeft();



  }
}
