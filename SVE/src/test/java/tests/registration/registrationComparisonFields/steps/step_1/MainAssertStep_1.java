package tests.registration.registrationComparisonFields.steps.step_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import tests.registration.registrationClassic.steps.step_1.MainStep_1;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_1.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_1.Expected.*;

public class MainAssertStep_1 extends BaseSteps {

  public MainAssertStep_1(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_1() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);

    Thread.sleep(3000);

    assertUtils.assertElementTextEquals(APPLICANT_LAST_NAME_FIELD, expectedApplicantLastName, "❌ Фамилия - введена неверно");
    assertUtils.assertElementTextEquals(APPLICANT_NAME_FIELD, expectedApplicantName, "❌ Имя - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_SURNAME_FIELD, expectedApplicantSurname, "❌ Отчество - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_BIRTHDAY_DATE_FIELD, expectedApplicantBirthDate,"❌ Дата рождения - введена неверно");
    assertUtils.assertElementTextEquals(APPLICANT_GENDER_FIELD, expectedApplicantGender,"❌ Пол - введено неверно");;
    assertUtils.assertElementTextEquals(APPLICANT_EMAIL_FIELD, expectedApplicantEmail, "❌ email - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_BIRTH_PLACE_FIELD, expectedApplicantBirthPlace, "❌ Место рождения - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_INDEX_FIELD, expectedApplicantIndex, "❌ Индекс - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_ADDRESS_FIELD, expectedApplicantAddress, "❌ Адрес регистрации - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_SNILS_FIELD, MainStep_1.Snils, "❌ Снилс - введено неверно");
    assertUtils.assertElementTextEquals(APPLICANT_PHONE_FIELD, "+7 " + expectedApplicantPhone, "❌ Телефон - введено неверно");
  }
}
