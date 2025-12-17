package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

public class AssertHintsPresent extends BaseSteps {

  public AssertHintsPresent (WebDriver driver,
                             WebDriverWait wait,
                             SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void assertHintsPresent(String[] hints) {
    String pageSource = driver.getPageSource();
    for (String hint : hints) {
      softAssert.assertTrue(pageSource.contains(hint), "❌ Ожидалась подсказка: " + hint);
    }
  }
}
