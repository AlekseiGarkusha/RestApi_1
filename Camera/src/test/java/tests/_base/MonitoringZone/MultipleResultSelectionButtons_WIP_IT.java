package tests._base.MonitoringZone;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import io.restassured.RestAssured;

import jdk.jfr.Description;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.Auth;
import setup.TestBase;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static data.Locators.MONITORING_ZONY;
import static data.Locators.VIEW_RESULTS;
import static data.UserData.LOGIN_ANALITIK_ITM;


/// WIP

public class MultipleResultSelectionButtons_WIP_IT extends TestBase {

  @BeforeClass
  void setup() {
    RestAssured.useRelaxedHTTPSValidation();
    RestAssured.baseURI = "https://itmrk.krtech.ru";
  }

  @Test(priority = 1)
  @Description("Авторизация")
  void login() {
    new Auth().fillLoginAndPassword(
      LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM);
  }

  @Test(priority = 2)
  @Description("Переход к реестру")
  void viewCards() {
    $x(MONITORING_ZONY).shouldBe(visible).click();
    $x(VIEW_RESULTS).shouldBe(visible).click();
  }

  @Test(priority = 3)
  @Description("Добавление в избранное")
  void addToFavourite() {
    SelenideElement checkBoxDisabled = $(".btn-add.disabled");

    $(".check").shouldBe(visible).click();
  }


  @Test(priority = 4)
  @Description("Удаление файла")
  void remove() throws InterruptedException {



    }

}
