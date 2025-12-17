package tests.registration.registrationComparisonFields.steps.step_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_6.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_6.Expected.*;

public class MainAssertStep_6 extends BaseSteps {

  public MainAssertStep_6(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_6() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);

    driver.findElement(By.xpath("//*[@id=\"statement-speciality-index-container\"]/table/tbody/tr/td[1]/div/div[1]/span")).click();

    assertUtils.assertElementTextEquals(MATHEMATIC_SCORE_FIELD, expectedMathematicsScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Математика'");
    assertUtils.assertElementTextEquals(COMPUTER_SCIENCE_SCORE_FIELD, expectedComputerScienceScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Информатика'");
    assertUtils.assertElementTextEquals(PHYSICS_SCORE_FIELD, expectedPhysicsScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Физика'");
    assertUtils.assertElementTextEquals(GEOGRAPHY_SCORE_FIELD, expectedGeographyScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'География'");
    assertUtils.assertElementTextEquals(CHINESE_SCORE_FIELD, expectedChineseScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Китайский язык'");
    assertUtils.assertElementTextEquals(LITERATURE_SCORE_FIELD, expectedLiteratureScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Литература'");
    assertUtils.assertElementTextEquals(SPANISH_SCORE_FIELD, expectedSpanishScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Испанский язык'");
    assertUtils.assertElementTextEquals(GERMAN_SCORE_FIELD, expectedGermanScore, "❌ Ошибка соответствия - Оценки по специальности - поле: 'Немецкий язык'");

  }
}
