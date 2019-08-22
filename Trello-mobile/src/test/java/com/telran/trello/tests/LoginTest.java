package com.telran.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
  @Test
  public void testLogin() throws InterruptedException {
    app.getSession().initLogin();
    app.getSession().fillLoginForm("passergiy@gmail.com", "7s9guYtfP7DRH5M");
  //app.getSession().closeKeyBoard();
    app.getSession().tapLoginButton();
    app.getSession().pause(2000);

    Assert.assertTrue(app.getSession().isUserLoggedIn());
  }
}
