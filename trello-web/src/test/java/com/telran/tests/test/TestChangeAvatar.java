package com.telran.tests.test;

import com.telran.tests.fw.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestChangeAvatar extends TestBase {
    @BeforeMethod
    public void preconditions() throws IOException {
        app.getProfile().takeScreenshot();// take screenshot
    }
    @Test
    public void changeAvatarTest() throws Exception {

        app.getHeader().clickOnHeaderMemberMenuButton();
        app.getProfile().clickOnProfileAndVisibilityOnHeader();
        app.getSession().pause(2000);
        app.getProfile().moveToImage();
        app.getProfile().attachPhotoToProfile(new File(
                "C:\\Users\\Passe\\OneDrive\\Documents\\GitHub\\Trello_Masa_Serj_Pas(Corected)\\trello-web\\src\\test\\resources\\Zajka.jpg"));
        app.getHeader().clickOnHomeButtonOnHeader();
    }
    @AfterMethod
    public void postActions() throws IOException {
        app.getProfile().takeScreenshot();// take screenshot
    }
}
