package com.telran.tests.test;

import com.telran.tests.fw.TestBase;
import org.testng.annotations.Test;

import java.io.File;

public class TestChangeAvatar extends TestBase {
    @Test
    public void changeAvatarTest(){
        app.getHeader().clickOnHeaderMemberMenuButton();
        app.getProfileHelper().clickOnProfileAndVisibilityOnHeader();
        app.getProfileHelper().moveToImage();
        app.getProfileHelper().attachPhotoToProfile(new File("src\\test\\resources\\Zajka.jpg"));
    }
}
