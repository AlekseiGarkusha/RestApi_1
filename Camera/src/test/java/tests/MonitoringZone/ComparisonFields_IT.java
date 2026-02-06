/**
* Тест сравнения привязки полей -- вводимых при добавлении зоны с полями в карточке
*/

package tests.MonitoringZone;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static data.Constants.*;
import static data.Locators.*;

public class ComparisonFields_IT extends MonitoringZoneCreate_IT {

  private String ZoneIdText;

  @Test(priority = 5)
  @Description("Переход в карточку")
  void goToCard() {
    SelenideElement ZoneId = $x("//table//td[@class='id'][1]");
    ZoneIdText = ZoneId.getText();
    $x("//tbody/tr[1]/td//div[@class='column-action']").click();
  }

  @Test(priority = 6)
  @Description("Сравнение полей")
  void assertFields() {
    // Получение названия
    SelenideElement actualZoneName = $(".page-title");
    actualZoneName.shouldHave(Condition.text(ZoneIdText));
    String actualZoneNameText = actualZoneName.getText();

    // Получение описания
    SelenideElement actualZoneDesc = $x(ZONE_MUNICIPALITY_DESCRIPTION);
    String actualZoneDescText = actualZoneDesc.getText();

    // Получение региона
    SelenideElement actualZoneMunicipality = $x(ZONE_MUNICIPALITY_NAME);
    String actualZoneMunicipalityText = actualZoneMunicipality.getText();

    Assert.assertEquals(actualZoneNameText, "Просмотр результатов мониторинга зоны № " + ZoneIdText + " " + ZONE_NAME, "❌ Название результата  не соответсвует");
    Assert.assertEquals(actualZoneDescText, ZONE_DESCRIPTION, "❌ Описание результата не соответсвует");
    Assert.assertEquals(actualZoneMunicipalityText, "Симферополь", "❌ Регион результата не соответсвует");
  }
}
