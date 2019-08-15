package com.telran.mobiletests.fw;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BaseHelper {
  public HeaderPage(WebDriver driver) {
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
