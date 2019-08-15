package com.telran.mobiletests.fw;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public  static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeMethod
  public void startLogger(Method method, Object [] parametrs){
    logger.info("Start Log" + method.getName() + "with parametrs " + Arrays.asList());
  }
  @AfterMethod
  public void stopLogger(Method method){
    logger.info("Stop Log" + method.getName());
  }


  @BeforeSuite
  public void setUp() throws InterruptedException {
    app.init();
  }

  @AfterSuite
  public void tearDown(){
    app.stop();
  }
}
