package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import static org.testng.Assert.assertEquals;

public class AssertUtils extends BaseSteps {

  private final SoftAssert softAssert;

  public AssertUtils(WebDriver driver, WebDriverWait wait, SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void assertElementTextEquals(By locator, String expectedText, String fieldName) {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    String actualText = element.getText().trim();
    softAssert.assertEquals(actualText, expectedText, "❌ Ошибка соответствия - поле: '" + fieldName + "'");
  }
}