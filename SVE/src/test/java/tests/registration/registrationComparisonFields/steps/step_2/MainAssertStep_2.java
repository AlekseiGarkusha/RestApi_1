package tests.registration.registrationComparisonFields.steps.step_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import tests.registration.registrationClassic.steps.step_2.MainStep_2;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_2.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_2.Expected.*;

public class MainAssertStep_2 extends BaseSteps {

  public MainAssertStep_2(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_2() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);
    assertUtils.assertElementTextEquals(APPLICANT_TYPE_DOCUMENT_FIELD, expectedApplicantTypeOfDocument, "❌  Ошибка соответствия - Документы заявителя - Тип документа");
    assertUtils.assertElementTextEquals(APPLICANT_SERIES_DOCUMENT_FIELD, MainStep_2.applicantDocumentSeries, "❌  Ошибка соответствия - Документы заявителя - Серия документа");
    assertUtils.assertElementTextEquals(APPLICANT_NUMBER_DOCUMENT_FIELD, MainStep_2.applicantDocumentNumber, "❌  Ошибка соответствия - Документы заявителя - Номер документа");
    assertUtils.assertElementTextEquals(APPLICANT_DOCUMENT_ISSUED_FIELD, expectedDocumentIssued, "❌  Ошибка соответствия - Документы заявителя - Кем выдан");
    assertUtils.assertElementTextEquals(APPLICANT_DOCUMENT_ISSUE_DATE, expectedDocumentIssueDate, "❌  Ошибка соответствия - Документы заявителя - Дата выдачи");
    assertUtils.assertElementTextEquals(APPLICANT_DOCUMENT_DEPARTMENT_CODE, expectedDocumentDepartmentCode, "❌  Ошибка соответствия - Документы заявителя - Код подразделения");
  }
}
