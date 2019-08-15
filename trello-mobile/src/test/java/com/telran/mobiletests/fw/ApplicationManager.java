package com.telran.mobiletests.fw;

import io.appium.java_client.AppiumDriver;

public class ApplicationManager {
    String browser;
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    HeaderPage header;
    ProfileHelper profileHelper;

    AppiumDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws InterruptedException {
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
