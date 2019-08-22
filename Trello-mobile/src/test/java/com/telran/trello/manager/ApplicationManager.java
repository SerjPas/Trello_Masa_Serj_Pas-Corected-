package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper session;
    AppiumDriver driver;
    HelloPage helloPage;

  public HelloPage getHelloPage() {
    return helloPage;
  }

  public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_3_API_28");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("app",
                "C:\\Users\\Passe\\OneDrive\\Documents\\GitHub\\Trello_Masa_Serj_Pas(Corected)\\Trello-mobile\\src\\test\\resources\\trello.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helloPage = new HelloPage(driver);
        session = new SessionHelper(driver);


        //  session.login("elena.telran@yahoo.com", "12345.com");
    }


    public void stop() {
        driver.quit();
    }

    public SessionHelper getSession() {
        return session;
    }

}
