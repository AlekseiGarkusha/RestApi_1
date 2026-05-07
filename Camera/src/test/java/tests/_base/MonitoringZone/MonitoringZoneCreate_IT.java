/**
 * Тест проверки создания зоны мониторинга
 * Тест покрывает заполнение всех полей
 * Создание зоны
 * Проверку на успешный popUp
 */

package tests._base.MonitoringZone;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;
import data.UserData;
import utils.PopUpUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static data.Constants.*;
import static data.Locators.*;

public class MonitoringZoneCreate_IT extends TestBase {

  @Test (priority = 1)
  @Description("Авторизация")
  public void login(){
    new Auth().fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM);
  }

  @Test(priority = 2)
  public void CreateMonitoringZone() throws InterruptedException {

    $x(MONITORING_ZONY).click();
    $x(BTN_ADD).click();

    $x(FIELD_NAME).sendKeys(ZONE_NAME);
    $x(FIELD_DESCRIPTION).sendKeys(ZONE_DESCRIPTION);

    $x(START_DATE_FIELD).click();
    sleep(2000);
    $(DAY_TODAY).shouldBe(visible).click();

    $x(FINAL_DATE_FIELD).click();

    for (int i = 0;i < 5; i++) {
      $x(BTN_NEXT_MONTH).click();
    }
    $x(FIRST_DAY).shouldBe(visible).click();

    $x(MUNICIPALITY_FIELD).click();
    $x(MUNICIPALITY_SYMFEROPOL).click();

    $x(CAMERA_FIELD).click();
    $x(CAMERA_CHOICE_159).click();

    $x(BTN_CAPTURE_FRAME).click();
    Thread.sleep(2000);

    // Установка точек для выбора зоны
    SelenideElement canvas = $(".canvas.c1");
    canvas.shouldBe(visible); // Проверка видимости

    int[][] points = {
      {-350, 0}, // первая точка
      {150, 0}, // вторая
      {20, -200}, // третья
      {-450, -200}, // четвёртая
      {-350, 0} // замыкает четырёхугольник
    };

    Actions actions = new Actions(WebDriverRunner.getWebDriver());

    for (int[] point : points) {
      actions.moveToElement(canvas, point[0], point[1]).click().perform();
    }

    $x(BTN_SAVE).click();
  }

  @Test (priority = 3)
  @Description("Проверка на всплывающий popUp")
  @Severity(SeverityLevel.CRITICAL)
  void popUp() {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(softAssert).assertPopUpContainsText(PopUpMessages.CREATED_MONITORING_SHEET);
    softAssert.assertAll();
  }
}
