package com.telran.tests.test;

import com.telran.tests.fw.DataProviders;
import com.telran.tests.fw.TestBase;
import com.telran.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCreateTeamFromHeder extends TestBase {
    /**
     * наш DataProvider лежит в класе DataProviders (DataProviders.class)
     */

    @Test(dataProvider = "teams", dataProviderClass = DataProviders.class)
    public void createTeamFromHeaderTestWithDataProviderTest(Team team) throws InterruptedException, IOException {
        int beforeTeamCreation = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamForm(team);
        app.getTeam().confirmTeamCreationButton();
        app.getHeader().clickOnHomeButtonOnHeader();

        int afterTeamCreation = app.getTeam().getTeamsCount();
        System.out.println("Teams before creation: " + beforeTeamCreation + " \n " + "Teams after creation: " + afterTeamCreation);
        Assert.assertEquals(afterTeamCreation, beforeTeamCreation + 1);
    }

    @Test(enabled = false) // swith off
    public void createTeamFromheaderTest() throws InterruptedException {

        int beforeTeamCreation = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamForm(new Team().setTeamName("Masa" + System.currentTimeMillis() % 100).setDescription("description"));
        app.getTeam().confirmTeamCreationButton();
        app.getHeader().clickOnHomeButtonOnHeader();

        int afterTeamCreation = app.getTeam().getTeamsCount();
        System.out.println("Teams before creation: " + beforeTeamCreation + " \n " + "Teams after creation: " + afterTeamCreation);
        Assert.assertEquals(afterTeamCreation, beforeTeamCreation + 1);
    }

    @AfterClass(alwaysRun = true)
    public void postAction() throws InterruptedException {
        app.getTeam().cleanTeams();
    }
}
