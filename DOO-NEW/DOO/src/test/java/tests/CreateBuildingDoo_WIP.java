/**
 * Тест добавления здания детского сада
 * Заполнение всех полей
 *
 */

package tests;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateBuildingDoo_WIP extends TestBase {
  @Test
  void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN,
      UserData.PASSWORD
    );
  }

  @Test(priority = 1)
  void goToCreateDoo() throws InterruptedException {
    $x("//span[normalize-space()='Организации']").click();
    $x("//div[@role='button' and .//span[normalize-space()='Здания Доо']]").click();
  }

  @Test
  public void CreateBuildingDoo() {
    SoftAssert softAssert = new SoftAssert();
    $x("//span[normalize-space()='Организации']").click();
    $x("//button[.//text()[normalize-space()='Добавить здание ДОО']]").click();


    SelenideElement expectedCreateDooTitle = $x("//span[normalize-space()='Добавление здания детского сада']");
    softAssert.assertTrue(expectedCreateDooTitle.exists(), "❌ Страница добавления 'Здания детского сада' не загрузилась");
    softAssert.assertAll();


    $x("//label[normalize-space()='Наименование здания ДОО']/following-sibling::div//input").sendKeys("Тестовое наименование");

    $x("//label[normalize-space()='Муниципалитет']/following-sibling::div//input").click();
    $("//li[@role='option' and normalize-space()='Симферополь']").click();

    $x("//label[normalize-space()='Адрес здания ДОО']/following-sibling::div//input").click();

    $x("//label[normalize-space()='Наименование здания ДОО']/following-sibling::div//input").sendKeys("90d05636-e3ac-4a7e-9633-e5b26d128d7c");



  }


}
