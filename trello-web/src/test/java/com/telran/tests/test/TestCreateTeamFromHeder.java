package com.telran.tests.test;

import com.telran.tests.fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestCreateTeamFromHeder extends TestBase {
  @Test
  public void createTeamFromheaderTest() throws InterruptedException {

    int beforeTeamCreation = app.getTeam().getTeamsCount();

    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamForm("Masa" + System.currentTimeMillis()%100, "description");
    app.getTeam().confirmTeamCreationButton();
    app.getHeader().clickOnHomeButtonOnHeader();

    int afterTeamCreation = app.getTeam().getTeamsCount();
    System.out.println("Teams before creation: " + beforeTeamCreation + " \n " + "Teams after creation: " + afterTeamCreation);
    Assert.assertEquals(afterTeamCreation, beforeTeamCreation+1 );
  }

  @AfterClass
  public void postAction() throws InterruptedException {
    app.getTeam().cleanTeams();
  }
}
