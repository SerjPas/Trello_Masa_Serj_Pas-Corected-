package com.telran.tests.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    HeaderPage header;
    ProfileHelper profileHelper;

    WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        } else {
            System.err.println("Unknown browser");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // full size screen

        driver.navigate().to("https://trello.com");
        session = new SessionHelper(driver);
        board = new BoardHelper(driver);
        team = new TeamHelper(driver);
        header = new HeaderPage(driver);
        profileHelper = new ProfileHelper(driver);

        session.login("passergiy@gmail.com", "7s9guYtfP7DRH5M");
    }


    public void stop() {
        //driver.quit();
    }

    public ProfileHelper getProfileHelper() {
        return profileHelper;
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public HeaderPage getHeader() {
        return header;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
