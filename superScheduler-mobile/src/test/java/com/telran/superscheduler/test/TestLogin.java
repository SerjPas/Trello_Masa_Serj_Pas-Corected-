package com.telran.superscheduler.test;

import com.telran.superscheduler.manager.TestBase;
import org.testng.annotations.Test;

@Test
public class TestLogin extends TestBase {
    public void testLogin() throws InterruptedException {
        app.getSession().fillLoginForm("tester12345@gmail.com", "Password123");
        app.getSession().clickLoginButton();
    }
}
