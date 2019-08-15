package com.telran.mobiletests.fw;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ApplicationManager {
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    HeaderPage header;
    ProfileHelper profile;
    EventFiringWebDriver driver;
    String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {

        session = new SessionHelper(driver);
        board = new BoardHelper(driver);
        team = new TeamHelper(driver);
        header = new HeaderPage(driver);
        profile =  new ProfileHelper(driver);

    }


    public void stop() {
        driver.quit();
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

    public ProfileHelper getProfile() {
        return profile;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
