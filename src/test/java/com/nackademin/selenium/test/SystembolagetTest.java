package com.nackademin.selenium.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SystembolagetTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.systembolaget.se";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSystembolaget() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("#modal-agecheck > div.modal-table > div.modal-row > div.modal-cell > div.content-wrapper > div.content > div.actions.ng-scope > button.action")).click();
    driver.findElement(By.linkText("Öppettider")).click();
    driver.findElement(By.id("sitesearch_input")).clear();
    driver.findElement(By.id("sitesearch_input")).sendKeys("Kiruna");
    driver.findElement(By.cssSelector("button.search-button.icon-only-button")).click();
    assertEquals("Hitta butiker och ombud | Systembolaget", driver.getTitle());
    assertEquals("Geologgatan 7 B", driver.findElement(By.cssSelector("span.pull-left.ng-binding")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}