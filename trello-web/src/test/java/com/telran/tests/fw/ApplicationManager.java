package com.telran.tests.fw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    HeaderPage header;
    ProfileHelper profile;
    EventFiringWebDriver driver;
    String browser;

    public class MyListener extends AbstractWebDriverEventListener{
        BaseHelper helper = new BaseHelper(driver);
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search element " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("element " +  by +" found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
            try {
                helper.takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver( new FirefoxDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EventFiringWebDriver(new EdgeDriver());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://trello.com");
        session = new SessionHelper(driver);
        board = new BoardHelper(driver);
        team = new TeamHelper(driver);
        header = new HeaderPage(driver);
        profile =  new ProfileHelper(driver);

        driver.register(new MyListener());
        session.login("passergiy@gmail.com", "7s9guYtfP7DRH5M");
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
