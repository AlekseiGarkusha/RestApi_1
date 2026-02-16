/** Переиспользуемая функция для проверки найденных pop-UP по текстуи */

package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;

public class PopUpUtils extends BaseSteps {

  private final SoftAssert softAssert;

  public PopUpUtils(SoftAssert softAssert) {
    this.softAssert = softAssert;
  }

  public void assertPopUpContainsText(String expectedPopUp) {
    try {

      SelenideElement popUp = $$x("//*[contains(text(), '" + expectedPopUp + "')]")
        .find(Condition.visible);

      popUp.shouldBe(Condition.visible, Duration.ofSeconds(10));

      softAssert.assertTrue(true, "✅ Попап с текстом '" + expectedPopUp + "' найден");

    } catch (com.codeborne.selenide.ex.ElementNotFound e) {
      softAssert.fail("❌ Попап с текстом '" + expectedPopUp + "' не появился на странице за 10 секунд");
    }
  }
}
