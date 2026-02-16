package tests.AITest;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;
import tests.AITest.resources.CreateDooData;
import tests.AITest.resources.CreateDooPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static tests.AITest.resources.CreateDooData.EXPECTED_ADDITIONAL;

public class CreateDooTest extends TestBase {

  @Test
  void login() {
    new Auth().fillLoginAndPassword(UserData.LOGIN, UserData.PASSWORD);
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
  @Description("Заполнение всех полей")
  void createDoo() {
    new CreateDooPage()
      .selectValue("Муниципалитет", CreateDooData.EXPECTED_MUNICIPALITY)
      .fillInput("Наименование ДОО", CreateDooData.EXPECTED_NAME_DOO)
      .selectValue("Статус ДОО", CreateDooData.EXPECTED_STATUS_DOO)
      .fillInput("Комментарий к статусу", CreateDooData.EXPECTED_COMMENT_STATUS)
      .fillInput("ИНН ДОО", CreateDooData.EXPECTED_INN_DOO)
      .fillInput("КПП ДОО", CreateDooData.EXPECTED_KPP_DOO)
      .selectValue("Организационная структура", CreateDooData.EXPECTED_ORGANIZE_STRUCTURE)
      .selectValue("Тип собственности", CreateDooData.EXPECTED_TYPE_OWNERSHIP)
      .selectValue("Тип местности", CreateDooData.EXPECTED_LOCALITY_TYPE)
      .fillInput("Уникальный номер в ГАР (Идентификатор ФИАС)", CreateDooData.EXPECTED_UNIQUE_GAR_NUMBER)
      .fillInput("Юридический адрес ДОО", CreateDooData.EXPECTED_LEGAL_ADDRESS)
      .checkCheckbox(CreateDooData.EXPECTED_LICENSE_CHECK)
      .checkCheckbox(CreateDooData.EXPECTED_CONTRACT_CHECK)
      .fillInput("ФИО руководителя", CreateDooData.EXPECTED_DIRECTOR_NAME)
      .fillInput("Режим работы", CreateDooData.EXPECTED_WORKING_HOURS)
      .selectValue("Тип питания", CreateDooData.EXPECTED_FOOD_TYPE)
      .fillInput("Сайт ДОО", CreateDooData.EXPECTED_WEBSITE)
      .fillInput("Электронная почта", CreateDooData.EXPECTED_EMAIL)
      .fillInput("Телефон", CreateDooData.EXPECTED_PHONE)
      .fillInput("Виды дополнительной образовательной деятельности", EXPECTED_ADDITIONAL)
      .fillInput("Особенности ДОО", CreateDooData.EXPECTED_FEATURES)
      .save();
  }

  @Test(priority = 3)
  @Description("Проверка на заполнение")
  public void verifyDooTableWithMap() {

    $x("//span[contains(@class, 'MuiAccordionSummary-expandIconWrapper')]").click();

    Map<String, String> expectedValues = new HashMap<>();
    expectedValues.put("Наименование ДОО", CreateDooData.EXPECTED_NAME_DOO);
    expectedValues.put("Муниципалитет", CreateDooData.EXPECTED_MUNICIPALITY);
    expectedValues.put("Статус ДОО", CreateDooData.EXPECTED_STATUS_DOO);
    expectedValues.put("Комментарий к статусу", CreateDooData.EXPECTED_COMMENT_STATUS);
    expectedValues.put("Тип собственности", CreateDooData.EXPECTED_TYPE_OWNERSHIP);
    expectedValues.put("Организационная структура", CreateDooData.EXPECTED_ORGANIZE_STRUCTURE);
    expectedValues.put("Наличие лицензии на ведение образовательной деятельности", "Имеется лицензия на образовательную деятельность");
    expectedValues.put("Юридический адрес ДОО", CreateDooData.EXPECTED_LEGAL_ADDRESS);
    expectedValues.put("ФИО руководителя", CreateDooData.EXPECTED_DIRECTOR_NAME);
    expectedValues.put("Часы работы", CreateDooData.EXPECTED_WORKING_HOURS);
    expectedValues.put("Сайт ДОО", CreateDooData.EXPECTED_WEBSITE);
    expectedValues.put("Электронная почта", CreateDooData.EXPECTED_EMAIL);
    expectedValues.put("Телефон", CreateDooData.EXPECTED_PHONE);

    expectedValues.put("ИНН ДОО", CreateDooData.EXPECTED_INN_DOO);
    expectedValues.put("КПП ДОО", CreateDooData.EXPECTED_KPP_DOO);
    expectedValues.put("Наличие договора на оказание образовательных услуг с другой ДОО", CreateDooData.EXPECTED_PHONE);
    expectedValues.put("Тип питания", CreateDooData.EXPECTED_PHONE);
    expectedValues.put("Тип местности", CreateDooData.EXPECTED_PHONE);
    expectedValues.put("Виды дополнительной образовательной деятельности", EXPECTED_ADDITIONAL);
    expectedValues.put("Особенности ДОО", CreateDooData.EXPECTED_FEATURES);

    SoftAssert softAssert = new SoftAssert();

    // Проходим по всем элементам Map
    for (Map.Entry<String, String> entry : expectedValues.entrySet()) {
      String field = entry.getKey();
      String expectedValue = entry.getValue();

      SelenideElement element = $x("//div[@class='SimpleTableRow']//div[.='" + field + "']/following-sibling::div");
      String actualValue = element.getText();

      softAssert.assertEquals(actualValue, expectedValue, "❌ Значение поля '" + field + "' не совпадает");
    }

    softAssert.assertAll();
  }
}
