package com.telran.tests.test;
import com.telran.tests.fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDeleteTeam extends TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!app.getTeam().isTeamPresent()) {
      app.getTeam().createTeam();
    }
  }

  @Test
  public void testTeamDeletion() throws InterruptedException {
    int beforeTestTeamCount = app.getTeam().getTeamsCount();

    app.getTeam().clickOnFirstTeam();
    app.getTeam().clickOnTeamSettings();
    app.getTeam().clickDeleteTeamLink();
    app.getTeam().confirmTeamDeletionButton();

    int afterTestTeamCount = app.getTeam().getTeamsCount();

    System.out.println("Teams before deleting: " + beforeTestTeamCount + "\n" + "Teams after deleting: " + afterTestTeamCount);

    Assert.assertEquals(afterTestTeamCount, beforeTestTeamCount - 1);
  }


}
