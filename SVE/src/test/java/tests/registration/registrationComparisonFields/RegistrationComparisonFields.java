/**
 * Тест сравнения полей при заполнении регистрации
 * с полями внутри заявления
 */

package tests.registration.registrationComparisonFields;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.BaseRegistration;
import tests.registration.registrationClassic.steps.step_1.MainStep_1;
import tests.registration.registrationClassic.steps.step_2.MainStep_2;
import tests.registration.registrationClassic.steps.step_3.MainStep_3;
import tests.registration.registrationClassic.steps.step_4.MainStep_4;
import tests.registration.registrationClassic.steps.step_5.MainStep_5;
import tests.registration.registrationClassic.steps.step_6.MainStep_6;
import tests.registration.registrationClassic.steps.step_7.MainStep_7;
import tests.registration.registrationClassic.steps.step_8.MainStep_8;
import tests.registration.registrationComparisonFields.steps.step_1.MainAssertStep_1;
import tests.registration.registrationComparisonFields.steps.step_2.MainAssertStep_2;
import tests.registration.registrationComparisonFields.steps.step_3.MainAssertStep_3;
import tests.registration.registrationComparisonFields.steps.step_4.MainAssertStep_4;
import tests.registration.registrationComparisonFields.steps.step_5.MainAssertStep_5;
import tests.registration.registrationComparisonFields.steps.step_6.MainAssertStep_6;
import tests.registration.registrationComparisonFields.steps.step_7.MainAssertStep_7;
import tests.registration.registrationComparisonFields.steps.step_8.MainAssertStep_8;
import utils.PopUpUtils;

public class RegistrationComparisonFields extends BaseRegistration {

  @Test(priority = 4)
  @Description("Полный цикл регистрации")
  @Severity(SeverityLevel.CRITICAL)
  public void fullRegistrationCycle() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    new MainStep_1(driver, wait).fillStep_1();
    new MainStep_2(driver, wait).fillStep_2();
    new MainStep_3(driver, wait).fillStep_3();
    new MainStep_4(driver, wait).fillStep_4();
    new MainStep_5(driver, wait).fillStep_5();
    new MainStep_6(driver, wait).fillStep_6();
    new MainStep_7(driver, wait).fillStep_7();
    new MainStep_8(driver, wait).fillStep_8();

    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.STATEMENT_CREATED);
    softAssert.assertAll();
  }

  @Test(priority = 16)
  @Description("Проверка соответствия всех полей")
  @Severity(SeverityLevel.CRITICAL)
  public void fullComparisonFields() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    new MainAssertStep_1(driver, wait, softAssert).fillAssertStep_1();
    new MainAssertStep_2(driver, wait, softAssert).fillAssertStep_2();
    new MainAssertStep_3(driver, wait, softAssert).fillAssertStep_3();
    new MainAssertStep_4(driver, wait, softAssert).fillAssertStep_4();
    new MainAssertStep_5(driver, wait, softAssert).fillAssertStep_5();
    new MainAssertStep_6(driver, wait, softAssert).fillAssertStep_6();
    new MainAssertStep_7(driver, wait, softAssert).fillAssertStep_7();
    new MainAssertStep_8(driver, wait, softAssert).fillAssertStep_8();

    softAssert.assertAll();
  }
}
