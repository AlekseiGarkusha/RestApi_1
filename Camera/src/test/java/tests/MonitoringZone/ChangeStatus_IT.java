/**
 * Тест проверки изменения статуса
 * для роли Аналитик
 * Проверка меняет статус мониторинга зоны и возвращает обратно
 */

package tests.MonitoringZone;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import setup.Auth;
import setup.Base;
import data.UserData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Locators.MONITORING_ZONY;

public class ChangeStatus_IT extends Base {

  @Test(priority = 1)
  void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM
    );
  }

  @Test(priority = 2)
  void changeStatus()  {
    $x(MONITORING_ZONY).shouldBe(visible).click();

    SelenideElement getInfoStatusOn = $(".table-checkbox.enabled").shouldBe(visible);
    SelenideElement getInfoStatusOff = $(".table-checkbox");
    SelenideElement getInfoStatusReadOnly = $(".table-checkbox.enabled.readonly");  // Для оператора

    if (getInfoStatusReadOnly.exists()) {
      org.testng.Assert.fail("❌ Изменение статуса не доступно");
    }

    if (getInfoStatusOn.exists()) {
      getInfoStatusOn.click();
    }

    if (getInfoStatusOff.exists()) {
      getInfoStatusOff.click();
    } else {
      org.testng.Assert.fail("❌ Изменение статуса не доступно");
    }
  }
}
