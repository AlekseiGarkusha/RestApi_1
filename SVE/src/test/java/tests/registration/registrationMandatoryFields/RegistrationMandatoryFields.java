/**
 * Тест проверки обязательных полей
 * при регистрации заявления
 * Доработать проверку полей, после добавления разработчиком подсказок.
 * 1. Специальные условия
 * 2. Индивидуальные достижения
 * 3. Оценка
 */

package tests.registration.registrationMandatoryFields;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import tests.registration.registrationMandatoryFields.hints.Hints;
import utils.AssertHintsPresent;
import utils.PopUpUtils;

import static tests.registration.registrationClassic.steps.step_1.Locators.*;
import static tests.registration.registrationClassic.steps.step_2.Locators.*;
import static tests.registration.registrationClassic.steps.step_3.Locators.*;
import static tests.registration.registrationClassic.steps.step_4.Locators.*;
import static tests.registration.registrationClassic.steps.step_5.Locators.*;
import static tests.registration.registrationClassic.steps.step_6.Locators.*;
import static tests.registration.registrationClassic.steps.step_7.Locators.*;
import static tests.registration.registrationClassic.steps.step_8.Locators.*;

public class RegistrationMandatoryFields extends BaseRegistration {

  @Test(priority = 4)
  @Description("Шаг 1й - Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_1() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_1)).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(NEXT_BUTTON_STEP_1)).click();

    Thread.sleep(2000);
    // Проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_1_HINTS);;
    softAssert.assertAll();
  }

  @Test(priority = 5)
  @Description("Шаг-1")
  @Severity(SeverityLevel.CRITICAL)
  public void step_1() {
    new MainStep_1(driver, wait).fillStep_1();
  }

  @Test(priority = 6)
  @Description("Шаг 2й - Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_2() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();


    Thread.sleep(1000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_2)).click();

    Thread.sleep(2000);

    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_2_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 7)
  @Description("Шаг 2 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_2() {
    new MainStep_2(driver, wait).fillStep_2();
  }

  @Test(priority = 8)
  @Description("Шаг-3 Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_3() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    Thread.sleep(1000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_3)).click();

    Thread.sleep(2000);

    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_3_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 9)
  @Description("Шаг 3 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_3() {
    new MainStep_3(driver, wait).fillStep_3();
  }

  @Test(priority = 10)
  @Description("Шаг-4 Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_4() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(2000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_4)).click();

    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_4_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 11)
  @Description("Шаг 4 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_4() {
    new MainStep_4(driver, wait).fillStep_4();
  }

  @Test(priority = 12)
  @Description("Шаг-5 Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_5() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(2000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_5)).click();

    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_5_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 13)
  @Description("Шаг 5 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_5() {
    new MainStep_5(driver, wait).fillStep_5();
  }

  @Test(priority = 14)
  @Description("Шаг-6 Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_6() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Thread.sleep(2000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_6)).click();

    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_6_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 15)
  @Description("Шаг 6 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_6() {
    new MainStep_6(driver, wait).fillStep_6();
  }

  @Test(priority = 16)
  @Description("Шаг-7 Обязательные поля")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_7() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    wait.until(ExpectedConditions.elementToBeClickable(SELECT_SPECIAL_CONDITIONS_FORM_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SELECT_BENEFITS)).click();
    driver.findElement(SELECT_REFERENCE_086U).click();
    driver.findElement(SPECIAL_CONDITIONS).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_INDIVIDUAL_ACHIEVEMENTS)).click();
    Thread.sleep(2000);
    driver.findElement(NEXT_BUTTON_STEP_7).click();
    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_7_HINTS);
    softAssert.assertAll();
  }


  @Test(priority = 17)
  @Description("Шаг 7 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_7() throws InterruptedException {
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormSerial(data.step_7.disabilityCertificate.series);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormNumber(data.step_7.disabilityCertificate.number);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormGroup(data.step_7.disabilityCertificate.group);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormReason(data.step_7.disabilityCertificate.reason);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormIssued(data.step_7.disabilityCertificate.issued);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormIssueDate(data.step_7.disabilityCertificate.issueDate);
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditionsFormExpirationDate(data.step_7.disabilityCertificate.expirationDate);

    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_1();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_2();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_3();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_4();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_5();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_6();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_7();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_8();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_9();
    new MainStep_7(driver, wait).methodsStep_7.fillBenefit_10();

    new MainStep_7(driver, wait).methodsStep_7.fillReferenceSeries(data.step_7.reference086u.o86uSeries);
    new MainStep_7(driver, wait).methodsStep_7.fillReferenceNumber(data.step_7.reference086u.o86uNumber);
    new MainStep_7(driver, wait).methodsStep_7.fillReferenceDate(data.step_7.reference086u.o86uDate);

    new MainStep_7(driver, wait).methodsStep_7.addExtendedMedicalCertificate();

    new MainStep_7(driver, wait).methodsStep_7.addConclusion_PMPK();

    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_1();
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_2();
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_3();
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_4();
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_5();
    new MainStep_7(driver, wait).methodsStep_7.fillSpecialConditions_6();

    new MainStep_7(driver, wait).methodsStep_7.fillIndividualAchievement_1();
    new MainStep_7(driver, wait).methodsStep_7.fillIndividualAchievement_1_score(data.step_7.individualAchievements.score_1);

    new MainStep_7(driver, wait).methodsStep_7.clickNext();
  }

  @Test(priority = 18)
  @Description("Шаг-8 Данные о законном представителе")
  @Severity(SeverityLevel.CRITICAL)
  public void hintsOnStep_8() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(2000);

    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_FINISH)).click();

    Thread.sleep(2000);
    // проверка на подсказки
    new AssertHintsPresent(driver, wait, softAssert).assertHintsPresent(Hints.STEP_8_HINTS);
    softAssert.assertAll();
  }

  @Test(priority = 19)
  @Description("Шаг 8 - Выполнение")
  @Severity(SeverityLevel.CRITICAL)
  public void step_8() throws InterruptedException {
    new MainStep_8(driver, wait).fillStep_8();
  }

  @Test(priority = 20)
  @Description("Проверка на всплывающий popUp")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.STATEMENT_CREATED);
    softAssert.assertAll();
  }
}
