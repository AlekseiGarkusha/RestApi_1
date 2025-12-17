package tests.registration.registrationComparisonFields.steps.step_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_3.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_3.Expected.*;
import static utils.GradeCalculator.GradeGenerator;

public class MainAssertStep_3 extends BaseSteps {

  public MainAssertStep_3 (WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_3() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);
    String expectedAverageScore = GradeGenerator();

    driver.findElement(By.id("custom-content-above-view-application-tab")).click();

    Thread.sleep(2000);

    assertUtils.assertElementTextEquals(EDUCATION_DOCUMENT_ISSUED_FIELD, expectedEducationDocumentIssued, "❌  Документ об образовани - поле: 'Кем выдан'");
    assertUtils.assertElementTextEquals(EDUCATION_DOCUMENT_SERIES_FIELD, expectedEducationDocumentSeries, "❌  Документ об образовани - поле: 'Серия'");
    assertUtils.assertElementTextEquals(EDUCATION_DOCUMENT_NUMBER_FIELD, expectedEducationDocumentNumber, "❌  Документ об образовани - поле: 'Номер документа'");
    assertUtils.assertElementTextEquals(EDUCATION_DOCUMENT_ISSUE_DATE_FIELD, expectedEducationDocumentIssueDate, "❌  Документ об образовани - поле: 'Дата выдачи'");
    assertUtils.assertElementTextEquals(RECEIVING_DOCUMENT_FIRST_FIELD, "Да", "❌  Документ об образовани - поле: 'Получение СПО впервые'");
    assertUtils.assertElementTextEquals(EDUCATION_DOCUMENT_AVERAGE_SCORE_FIELD, expectedAverageScore, "❌  Документ об образовани - поле: 'средний балл не соответствует'");
  }
}
