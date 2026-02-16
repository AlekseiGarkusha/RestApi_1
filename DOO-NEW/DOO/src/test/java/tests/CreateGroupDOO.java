package tests;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;
import tests.AITest.resources.CreateDooData;
import tests.AITest.resources.CreateDooPage;
import utils.GenerateRandomSeries;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.$x;

public class CreateGroupDOO extends TestBase {


  @Test(priority = 1)
  @Description("Авторизация")
  void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN,
      UserData.PASSWORD
    );
  }

  @Test(priority = 2)
  @Description("Переход к созданию группы")
  void goToCreateGroupDoo() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    $x("//span[normalize-space()='Организации']").click();
    $x("//div[@role='button' and .//span[normalize-space()='Группы ДОО']]").click();
    $x("//button[.//text()[normalize-space()='Добавить группу ДОО']]").click();

    Thread.sleep(2000);
    SelenideElement expectedTitle = $x("//span[normalize-space()='Добавление группы детского сада']");

    softAssert.assertTrue(expectedTitle.exists(), "❌ Страница добавления группы детского сада не загрузилась");
    softAssert.assertAll();
  }

  public static String CREATE_GROUP__GROUP_NAME = "//input[@id=//label[normalize-space()='Наименование группы ДОО']/@for]";
  public static String CREATE_GROUP__MUNICIPALITY_DROPDOWN = "//input[@id=//label[normalize-space()='Муниципалитет']/@for]";
  public static String CREATE_GROUP__MUNICIPALITY_SIMFEROPOL = "//ul[@role='listbox']//li[@data-value='Симферополь']";
  public static String CREATE_GROUP__ADDRESS_BUILDING = "//input[@id=//label[normalize-space()='Муниципалитет']/@for]";
  public static String CREATE_GROUP__FIAS = "//input[@id=//label[normalize-space()='Уникальный номер в ГАР (Идентификатор ФИАС)']/@for]";



  //=======================================================================================
  public static String expectedGroupName = "Тестовое наименование группы ДОО: " + GenerateRandomSeries.generateRandomSeries();
  public static String expectedMunicipality = "Симферополь";
  public static String expectedAddressBuilding = "Крым - тестовый адресс здания ДОО";
  public static String expectedFias = "1adc543c-e4c9-4c27-ab97-31548926acd4";



  @Test
  @Description("Заполнение всех полей")
  void fillAllFields() {
    $x(CREATE_GROUP__GROUP_NAME).sendKeys(expectedGroupName);
    $x(CREATE_GROUP__MUNICIPALITY_DROPDOWN).click();
    $x(CREATE_GROUP__MUNICIPALITY_SIMFEROPOL).click();

    $x(CREATE_GROUP__ADDRESS_BUILDING).sendKeys(expectedAddressBuilding);
    $x(CREATE_GROUP__FIAS).sendKeys(expectedFias);
    $x("").click();
    $x("").click();
    $x("").click();
    $x("").click();
    $x("").click();
    $x("").click();
    $x("").click();

  }


}
