/* Тест проверки открытия реестра "Мониторинга зоны"*/

package tests._base.MonitoringZone;

import data.DataTitle;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Auth;
import setup.TestBase;
import data.UserData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Locators.MONITORING_ZONY;

public class OpenRegistryZony_IT extends TestBase {

  @Test(priority = 1)
  @Description("Авторизация")
  void login() {
    new Auth().fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM);
  }

  @Test(priority = 2)
  @Description("Переход к реестру и проверка на наличие заголовка")
  void goToRegister() {
    $x(MONITORING_ZONY).click();
    String pageTitle = $(".page-title").getText();
    Assert.assertEquals(pageTitle, DataTitle.TITLE_ZONE_MONITORING, "❌ Реестр 'Мониторинг зоны не доступен'");
  }
}
