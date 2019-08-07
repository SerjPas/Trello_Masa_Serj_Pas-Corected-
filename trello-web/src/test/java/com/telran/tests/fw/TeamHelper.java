package com.telran.tests.fw;

import com.telran.tests.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends BaseHelper {
    HeaderPage header = new HeaderPage(driver);

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void confirmTeamDeletionButton() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".js-confirm")));

        click(By.cssSelector(".js-confirm"));
    }

    public void clickDeleteTeamLink() throws InterruptedException {
        click(By.cssSelector(".quiet-button"));
    }

    public void clickOnTeamSettings() {
        click(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."));
    }

    public void clickOnFirstTeam() throws InterruptedException {
        pause(1000);
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public int getTeamsCount() throws InterruptedException {
        pause(1000);

        WebElement teamsList = driver.findElement(By
                .cssSelector("nav.home-left-sidebar-container .js-react-root"));
        return teamsList.findElements(By.xpath(".//li")).size();
    }

    public int getTeamsCount2() {
        return driver.findElements(By
                .cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
    }

    public boolean isTeamPresent() {
        //._1vHmTKeiB3R9df .js-react-root li
        return isElementPresent(By
                .cssSelector(".home-left-sidebar-container .js-react-root li"));
    }

    public void createTeam() throws InterruptedException {
        header.clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamForm("Masa" + System.currentTimeMillis() % 100, "description");
        confirmTeamCreationButton();
        header.clickOnHomeButtonOnHeader();
    }

    public void confirmTeamCreationButton() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void fillTeamForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.xpath("//*[@name='desc']"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.xpath("//*[@data-test-id='header-create-team-button']"));
    }

    public void cleanTeams() throws InterruptedException {
        int count = getTeamsCount();
        while (count > 3) {
            clickOnFirstTeam();
            clickOnTeamSettings();
            clickDeleteTeamLink();
            confirmTeamDeletionButton();
            count = getTeamsCount();
        }
    }
    public void clickOnCreateATeam() {
        click(By.xpath("//span[@class='icon-add icon-sm OiX3P2i2J92Xat']"));
    }

    public void fillTeamCreationForm(Team team) {
        new Team("MASA -" + System.currentTimeMillis()%100, "");


    }

    public void confirmCreate() {
        click(By.cssSelector("[value=\"Create\"]"));
    }
}
