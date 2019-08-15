package com.telran.tests.fw;

import org.openqa.selenium.*;
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
    String browser;
    SessionHelper session;
    BoardHelper board;
    TeamHelper team;
    HeaderPage header;
    ProfileHelper profileHelper;

    EventFiringWebDriver driver;

    /**
     * Создаем MyListener для автоматизации регистрации событий в нашей програме
     */

    public class MyListener extends AbstractWebDriverEventListener {
        BaseHelper baseHelper = new BaseHelper(driver);
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search element " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Element " + by + " found.");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
            try {
                baseHelper.takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**
             * ошибка будет преобразована в текст
             */
        }
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.CHROME)) {
            /**
             * сначала строим new EventFiringWebDriver - это регистратор который помагает автоматизировать лог
             * и внутри его уже new ChromeDriver()
             */
            driver = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EventFiringWebDriver(new EdgeDriver());
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


        driver.register(new MyListener());

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
