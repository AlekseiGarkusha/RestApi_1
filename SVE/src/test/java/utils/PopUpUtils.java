/**
 * Переиспользуемая функция для проверки найденных pop-UP по тексту
 */

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import java.time.Duration;
import java.util.List;

public class PopUpUtils extends BaseSteps {

  public PopUpUtils(WebDriver driver,
                    WebDriverWait wait,
                    SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void assertPopUpContainsText(String expectedPopUp) {
    try {
      boolean found = wait.withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(500))
        .until(driver -> {
          List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + expectedPopUp + "')]"));
          for (WebElement el : elements) {
            if (el.isDisplayed()) return true;
          }
          return false;
        });

      softAssert.assertTrue(found, "❌ Всплывающее сообщение с текстом '" + expectedPopUp + "' не найдено");

    } catch (TimeoutException e) {
      softAssert.fail("❌ Попап с текстом '" + expectedPopUp + "' не появился на странице за 10 секунд");
    }
  }
}
