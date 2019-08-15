package com.telran.tests.test;

import com.telran.tests.fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogIn extends TestBase {
  @BeforeMethod
public void preconditions(){
  app.getSession().logout();
}
  @Test
  public void loginTest() throws InterruptedException {
    /**
     * проверяем что после лог аута Url = "https://trello.com/logged-out"
     */
    String currentUrl = app.getUrl();

    Assert.assertEquals(currentUrl, "https://trello.com/logged-out");

    app.getSession().clickOnLoginButton();
    app.getSession().fillUserForm("ppassergiy@gmail.com", "7s9guYtfP7DRH5M");
    app.getSession().confirmLoginButton();
    app.getSession().pause(2000);
    /**
     * Проверяем залогирован ли юзер - если "ДА" - вернет true
     */
    Assert.assertTrue(app.getSession().isUserLoggedIn());
  }


}
