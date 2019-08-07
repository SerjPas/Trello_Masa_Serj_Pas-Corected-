package com.telran.tests.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateTeamTests extends  TestBase{
  @Test
  public void createTeamFromheaderTest() throws InterruptedException {

    int before = app.getTeam().getTeamsCount();

    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamForm("M-" + System.currentTimeMillis(), "description");
    app.getTeam().confirmTeamCreationButton();
    app.getHeader().clickOnHomeButtonOnHeader();

    int after = app.getTeam().getTeamsCount();

    Assert.assertEquals(after, before+1 );
  }

  @AfterClass
  public void postAction() throws InterruptedException {
    app.getTeam().cleanTeams();
  }
}
