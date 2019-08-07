package com.telran.tests.test;
import com.telran.tests.fw.TestBase;
import com.telran.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestTeamCreation extends TestBase {
    @Test
    public void teamCreationTest() throws InterruptedException {
        int beforeTeamCreation = app.getTeam().getTeamsCount();

        app.getTeam().clickOnCreateATeam();
        app.getTeam().fillTeamCreationForm(new Team("NewSuperTeam" + System.currentTimeMillis() % 100,"desc"));
        app.getTeam().confirmCreate();
        app.getHeader().clickOnHomeButtonOnHeader();
        app.getSession().pause(1000);

        int afterTeamCreation = app.getTeam().getTeamsCount();
        System.out.println("Teams before creation: " + beforeTeamCreation + " \n " + "Teams after creation: " + afterTeamCreation);
        Assert.assertEquals(afterTeamCreation, beforeTeamCreation, +1); //проверка что разница после теста в 1 доску
        // afterCreation -(minus) beforeCreation = 1
    }
    @AfterClass
    public void postAction() throws InterruptedException {
        app.getTeam().cleanTeams();
    }
}
