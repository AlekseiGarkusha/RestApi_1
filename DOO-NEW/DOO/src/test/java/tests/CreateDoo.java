package tests;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;
import utils.GenerateRandomSeries;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Constants.STATUS_DESCRIPTION;

public class CreateDoo extends TestBase {

  public static String expectedDescription = "Комментарий к статусу";
  public static String expectedINN = "1234567890";
  public static String expectedKPP = "111000666";

  public static String createDOO_INN = "//input[@name='inn']";
  public static String createDOO_KPP = "//input[@name='kpp']";

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
    SoftAssert softAssert = new SoftAssert();
    $x("//span[normalize-space()='Организации']").click();
    $x("//div[@role='button' and .//span[normalize-space()='Детские сады']]").click();
    $x("//button[.//text()[normalize-space()='Добавить детский сад']]").click();


    Thread.sleep(2000);
    SelenideElement expectedTitle = $x("//span[normalize-space()='Добавление детского сада']");

    softAssert.assertTrue(expectedTitle.exists(), "❌ Страница добавления детского сада не загрузилась");
    softAssert.assertAll();
  }



  @Test(priority = 2)
  void createDoo() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    $("#_r_3p_").click();
    $x("//ul[@role='listbox']//li[normalize-space()='Симферополь']").click();

    $x("//input[@placeholder='Введите полное наименование детского сада']").sendKeys("Тестовое наименование ДОО: " + GenerateRandomSeries.generateRandomSeries());

    $x("//label[contains(normalize-space(.),'Статус')]/following::div[@role='combobox'][1]").click();
    $x("//ul[@role='listbox']//li[normalize-space()='Контингент отсутствует']").click();

    Thread.sleep(2000);

    /**
     * Можно развернуть проверку на каждый из статусов
     */

    SelenideElement expectedFieldDescription = $x(STATUS_DESCRIPTION);

//    softAssert.assertTrue(expectedFieldDescription.exists(), "❌ Комментарий для статуса 'Контингент Отсутствует' - не появился");
//    softAssert.assertAll();


    expectedFieldDescription.sendKeys(expectedDescription);

    $x(createDOO_INN).sendKeys(expectedINN);
    $x(createDOO_KPP).sendKeys(expectedKPP);

    $x("//label[contains(normalize-space(.),'Организационная структура')]/following::div[@role='combobox'][1]").click();
    $x("//ul[@role='listbox']//li[normalize-space()='Дошкольные группы при другой организации (кроме ВУЗов)']").click();

    $x("//div[input[@name='typeID']]").click();
    $x("//ul[@role='listbox']//li[normalize-space()='Государственная']").click();


    $x("//div[input[@name='typeAreaID']]").click();
    $x("//ul[@role='listbox']//li[normalize-space()='Городская местность']").click();

    $x("//div[input[@name='fiasOrgGUID']]").sendKeys("60944f80-a983-488f-86e7-426c7e88a750");
    $x("//div[input[@name='orgAddress']]").sendKeys("Тестовый Юридический адрес");

    $x("//div[.//span[text()='Наличие лицензии на ведение образовательной деятельности']]//input[@type='checkbox']").click();
    $x("//div[.//span[text()='Наличие договора на оказание образовательных услуг с другой ДОО']]//input[@type='checkbox']").click();
  }
}
