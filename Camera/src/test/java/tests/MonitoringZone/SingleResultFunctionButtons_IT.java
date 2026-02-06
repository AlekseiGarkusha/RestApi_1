/**
 * Позитивная проверка доступности фукнцоинальных кнопок результата мониторинга
 * Просмотр Фото
 * Просмотр Видео
 * Скачивание файла - проверка что файл действительно был скачан
 * Удаление файла - проверка что файл действительно был удалён
 */

package tests.MonitoringZone;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.UserData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.Base;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.*;
import static data.Btn.DELETION_CONFIRMATION;
import static data.Btn.DELETION_SINGLE_BTN;
import static data.Locators.*;
import static io.restassured.RestAssured.given;

public class SingleResultFunctionButtons_IT extends Base {

  private String idCard;

  @Test(priority = 1)
  @Description("Авторизация")
  void login() {
    new Auth().fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM);
  }

  @Test(priority = 2)
  @Description("Переход к реестру c существующими результатами и датой")
  void viewCards() throws InterruptedException {
    $x(MONITORING_ZONY).shouldBe(visible).click();
    Thread.sleep(2000);

    ElementsCollection rows = $$("tr.enabled");

    SelenideElement targetRow = null;

    for (SelenideElement row : rows) {
      String countText = row.$(".count").getText().trim();

      idCard = row.$(".id").getText();

      if (!countText.equals("0")) {
        targetRow = row;
        break;
      }
    }

    targetRow.$x(".//a[.//div[normalize-space(text())='посмотреть результаты']]").click();
  }

  @Test(priority = 3)
  @Description("Проверка на открытие и закрытие фото")
  void openAndClosePhoto() throws InterruptedException {
    Thread.sleep(2000);

    $x(BTN_OPEN_PHOTO).shouldBe(visible).click();
    SelenideElement btnClosePhoto = $(BTN_CLOSE_PHOTO);

    if (btnClosePhoto.exists()) {
      btnClosePhoto.shouldBe(visible).click();
    } else {
      Assert.fail("❌ Ошибка просмотра фото");
    }
  }

  @Test(priority = 4)
  @Description("Проверка на открытие и закрытие Видео")
  void openAndCloseVideo() throws InterruptedException {
    $x(BTN_OPEN_VIDEO).shouldBe(visible).click();

    sleep(2000);

    SelenideElement btnCloseVideo = $x(BTN_CLOSE_VIDEO);

    if (btnCloseVideo.exists()) {
      //  sleep(2000);
      btnCloseVideo.shouldBe(visible).click();
    } else {
      Assert.fail("❌ Ошибка просмотра видео");
    }
  }

  @Test(priority = 5)
  @Description("Проверка на скачивание найденного")
  void download() {
    SelenideElement fileNameElement = $x("//tbody/tr[1]/td[4]");
    String fileName = fileNameElement.getText();

    File downloadedFile = $x(LOAD_FOUND).shouldBe(visible).download();

    Assert.assertTrue(downloadedFile.getName().contains(fileName),
      "❌ Файл не скачан или название не соответствует. Скачанный файл:" + downloadedFile.getName());
  }

  @Test(priority = 6)
  @Description("Проверка на удаление файла")
  void deleteSingleFile() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    // Получение куки для авторизации запроса RestAssured
    String baseCookie = WebDriverRunner
      .getWebDriver()
      .manage()
      .getCookieNamed("SESSION")
      .getValue();

    RestAssured.useRelaxedHTTPSValidation(); // игнорировать проверку SSL -- удалить после создания сервиса !!!!!!!!!!!!
    String baseURI = "https://itmrk.krtech.ru";
    String endpoint = "/api/notification/zone/"+ idCard + "/list";

    // запрос для получения обьекта со всеми карточками.
    String requestBody = """
      {
          "page": 1,
          "itemsOnPage": 50,
          "sort": {
              "sortBy": "dateTime",
              "dir": "desc"
          }
      }
      """;

    Response responseBefore = given()
      .cookie("SESSION", baseCookie)
      .baseUri(baseURI)
      .contentType(ContentType.JSON)
      .accept("*/*")
      .body(requestBody)
      .when()
      .post(endpoint)
      .then()
      .statusCode(200)
      .extract()
      .response();

    JsonPath jsonBefore = responseBefore.jsonPath();
    int totalBeforeDelete = jsonBefore.getInt("response.navigation.total");
//     System.out.println("Total before delete: " + totalBeforeDelete);

    $x(DELETION_SINGLE_BTN).shouldBe(visible).click();
    Thread.sleep(2000);

    $x(DELETION_CONFIRMATION).shouldBe(visible).click();
    Thread.sleep(2000);

    // Получение total после удаления
    Response responseAfter = given()
      .cookie("SESSION", baseCookie)
      .baseUri(baseURI)
      .contentType(ContentType.JSON)
      .accept("*/*")
      .body(requestBody)
      .when()
      .post(endpoint)
      .then()
      .statusCode(200)
      .extract()
      .response();

    JsonPath jsonAfter = responseAfter.jsonPath();
    int totalAfterDelete = jsonAfter.getInt("response.navigation.total");
    // System.out.println("Total after delete: " + totalAfterDelete);

    // Проверка, что total уменьшился
    softAssert.assertNotEquals(totalBeforeDelete, totalAfterDelete, "❌ Карточка результата не удалена");
    softAssert.assertAll();
  }
}