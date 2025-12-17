package tests.registration.registrationComparisonFields.steps.step_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

public class MainAssertStep_5 extends BaseSteps {

  public static String expectedListSpecialties = data.step_5.speciality;
  public static final By LIST_SPECIALTIES_FIELD = By.xpath("//*[@id=\"statement-speciality-index-container\"]/table/tbody/tr/td[2]");

  public MainAssertStep_5(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_5() {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);

    assertUtils.assertElementTextEquals(
      LIST_SPECIALTIES_FIELD,
      expectedListSpecialties,
      "❌ Ошибка соответствия - Специальности - поле: 'Список специальностей/профессий'");
    // Оригинал документа  - не реализована проверка т.к. неизвестно как проверять по картинке
  }
}
