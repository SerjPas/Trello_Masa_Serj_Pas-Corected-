package com.telran.tests.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  SessionHelper session;
  BoardHelper board;
  TeamHelper team;
  HeaderPage header;

  WebDriver driver;

  public void init() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize(); // full size screen

    driver.navigate().to("https://trello.com");
    session = new SessionHelper(driver);
    board = new BoardHelper(driver);
    team = new TeamHelper(driver);
    header = new HeaderPage(driver);

    session.login("passergiy@gmail.com", "7s9guYtfP7DRH5M");
  }


  public void stop() {
   // driver.quit();
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
