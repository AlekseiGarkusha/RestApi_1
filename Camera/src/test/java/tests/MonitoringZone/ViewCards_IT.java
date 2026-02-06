/**
 * Тест проверки доступности просмотра карточки результата
 *
 * Если найдена кнопка "Добавить в избранное",
 * то карточка отрыта, и просмотр доступен.
*/

package tests.MonitoringZone;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Auth;
import setup.Base;
import data.UserData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static data.Locators.*;

public class ViewCards_IT extends Base {

  @Test(priority = 1)
  @Description("Авторизация")
  public void login() {
    new Auth().fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM);
  }

  @Test(priority = 2)
  @Description("Переход к реестру и просмотр карточки")
  void viewCards() {
    $x(MONITORING_ZONY).shouldBe(visible).click();
    $x(VIEW_RESULTS).shouldBe(visible).click();

    SelenideElement btnFavorites = $x(REGION_DEFINITION).shouldBe(visible);

    if (!btnFavorites.exists()) {
      Assert.fail("❌ Просмотр карточки результата не доступен");
    }
  }
}
