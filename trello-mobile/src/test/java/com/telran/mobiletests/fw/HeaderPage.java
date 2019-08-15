package com.telran.mobiletests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderPage extends BaseHelper {
  public HeaderPage(AppiumDriver driver) {
    super(driver);
  }

  public void clickOnHomeButtonOnHeader() throws InterruptedException {
    pause(1000);
    click(By.cssSelector("a [name=house]"));
    pause(1000);
    click(By.cssSelector("a [name=house]"));
  }

  public void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }
  public void clickOnHeaderMemberMenuButton() {
    click(By.cssSelector("[data-test-id=\"header-member-menu-button\"]"));
 }

}
