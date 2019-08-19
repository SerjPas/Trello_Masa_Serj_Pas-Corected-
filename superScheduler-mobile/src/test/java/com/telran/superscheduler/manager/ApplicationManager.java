package com.telran.superscheduler.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper session;

    AppiumDriver driver;

    public void init() throws InterruptedException, MalformedURLException {
        /**
         * настройки для Appium
         * 7 capabilities
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","OnePlus3t");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "C:\\Users\\Passe\\OneDrive\\Documents\\GitHub\\Trello_Masa_Serj_Pas(Corected)\\superScheduler-mobile\\src\\test\\resources\\v.0.0.2.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        session = new SessionHelper(driver);
    //    session.login("passergiy@gmail.com", "7s9guYtfP7DRH5M");
    }


    public void stop() {
        driver.quit();
    }

    public SessionHelper getSession() {
        return session;
    }

}
