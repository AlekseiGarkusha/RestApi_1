/** Тест - изменения данных заявителя в карточке
 * Проверки
 * 1 - Изменение данных в карточке заявителя
 * 2 - Соответствие данных
 * 2 - Дата обновления
 * 3 - Всптывающий pop-Up
 */

package tests.adminOO.changeApplicantData;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;
import utils.random.GenerateRandomSnils;

public class ChangeApplicantData extends Base {

  public static String expectedNewSnils = GenerateRandomSnils.generateRandomSnils();
  public static String expectedGender = null;

  @Test(priority = 2)
  @Description("Переход к реестру заявлений, применение фильтров, переход к первому заявлению")
  @Severity(SeverityLevel.CRITICAL)
  public void openRegistryApplications() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Methods methods = new Methods(driver, wait, softAssert);

    methods.openRegisterOfApplications();
    methods.changeFilterStatusAccepted();
    methods.changeFilterPersonalReception();

    Thread.sleep(2000);

    methods.openApplicationCard();
  }

  @Test(priority = 3)
  @Description("Изменение данных и проверка popUp")
  @Severity(SeverityLevel.CRITICAL)
  public void changeApplicantData() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Methods methods = new Methods(driver, wait, softAssert);

    methods.clickChangeDataBtn();
    methods.changeApplicantSurname();
    methods.changeApplicantName();
    methods.changeApplicantPatronymic();
    expectedGender = methods.changeApplicantGender();
    methods.changeApplicantBirthDate();
    methods.changeApplicantBirthPlace();
    methods.changeApplicantIndex();
    methods.changeApplicantAddress();
    methods.changeApplicantSnils(expectedNewSnils);
    methods.changeApplicantEmail();
    methods.changeApplicantPhone();
    methods.clickBtnChangesSave();

    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.CHANGE_APPLICANT_DATA);
    softAssert.assertAll();
  }

  @Test(priority = 4)
  @Description("Проверка изменённых полей")
  @Severity(SeverityLevel.CRITICAL)
  public void assertChangedFields() {
    SoftAssert softAssert = new SoftAssert();
    Methods methods = new Methods(driver, wait, softAssert);

    methods.assertApplicantSurname();
    methods.assertApplicantName();
    methods.assertApplicantPatronymic();
    methods.assertApplicantGender(expectedGender);  // включить после доработки
    methods.assertApplicantBirthDate();
    methods.assertApplicantBirthPlace();
    methods.assertApplicantIndex();
    methods.assertApplicantAddress();
    methods.assertApplicantSnils(expectedNewSnils);
    methods.assertApplicantEmail();
    methods.assertApplicantPhone();
    methods.assertApplicantDateUpdate();

    softAssert.assertAll();
    
  }
}

