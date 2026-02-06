/**
 * Позитивный тест "поиска" в реестре - Мониторинг зоны
 *
 * Тест зависит от теста создания "Зоны Мониторинга"
 * Тест проверяет только позитивную проверку
 */

package tests.MonitoringZone;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static data.Constants.ZONE_NAME;
import static data.Locators.MONITORING_ZONY;
import static data.Locators.SEARCH;

public class SearchTest_IT extends MonitoringZoneCreate_IT {
  @Test(priority = 4)
  @Description("Переход к реестру и просмотр карточки")
  void viewCards() {
    $x(MONITORING_ZONY).shouldBe(visible).click();
    $x(SEARCH).sendKeys(ZONE_NAME);

    SelenideElement zoneCardName = $x("//td[@class='name']").shouldBe(visible);
    Assert.assertEquals(zoneCardName.getText(), ZONE_NAME, "❌ Поиск не нашёл созданную карточку зоны");
  }
}
