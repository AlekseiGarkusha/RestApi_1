package tests.checkDuplicate.statement;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.BaseRegistration;
import tests.registration.registrationClassic.steps.step_1.MethodsStep_1;
import tests.registration.registrationClassic.steps.step_2.MethodsStep_2;
import tests.registration.registrationClassic.steps.step_3.MainStep_3;
import tests.registration.registrationClassic.steps.step_4.MainStep_4;
import tests.registration.registrationClassic.steps.step_5.MainStep_5;
import tests.registration.registrationClassic.steps.step_6.MainStep_6;
import tests.registration.registrationClassic.steps.step_7.MainStep_7;
import tests.registration.registrationClassic.steps.step_8.MainStep_8;

import utils.PopUpUtils;
import utils.random.GenerateRandomNumber;
import utils.random.GenerateRandomSeries;
import utils.random.GenerateRandomSnils;

import static tests.registration.registrationClassic.steps.step_1.Locators.*;
import static tests.registration.registrationClassic.steps.step_2.Locators.*;

public class CheckDuplicateStatement extends BaseRegistration {

  public static final String snils = GenerateRandomSnils.generateRandomSnils();
  public static final String series = GenerateRandomSeries.generateRandomSeries();
  public static final String number = GenerateRandomNumber.generateRandomNumber();

  @Test(priority = 4)
  @Description("Шаг-1")
  @Severity(SeverityLevel.CRITICAL)
  public void step_1() {
    new MethodsStep_1(driver,wait).fillApplicantLastname(data.step_1.lastName);
    new MethodsStep_1(driver,wait).fillApplicantName(data.step_1.name);
    new MethodsStep_1(driver,wait).fillApplicantPatronymic(data.step_1.patronymic);
    new MethodsStep_1(driver,wait).fillApplicantBirthdate(data.step_1.birthDate);
    new MethodsStep_1(driver,wait).fillApplicantGender();
    new MethodsStep_1(driver,wait).fillApplicantBirthPlace(data.step_1.birthPlace);
    new MethodsStep_1(driver,wait).fillApplicantBirthAddress(data.step_1.address);
    new MethodsStep_1(driver,wait).fillApplicantIndex(data.step_1.index);
    driver.findElement(APPLICANT_SNILS).sendKeys(CheckDuplicateStatement.snils);
    new MethodsStep_1(driver,wait).fillApplicantPhone(data.step_1.phone);
    new MethodsStep_1(driver,wait).clickNext();
  }

  @Test(priority = 5)
  @Description("Шаг-2 Тип документа")
  @Severity(SeverityLevel.CRITICAL)
  public void step_2() {
    new MethodsStep_2(driver,wait).fillTypeOfDocument();
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_SERIES)).sendKeys(CheckDuplicateStatement.series);
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_NUMBER)).sendKeys(CheckDuplicateStatement.number);
    new MethodsStep_2(driver,wait).fillDocumentIssued(data.step_2.documentIssued);
    new MethodsStep_2(driver,wait).fillDocumentIssueDate(data.step_2.documentIssueDate + Keys.ENTER);
    new MethodsStep_2(driver,wait).fillDocumentDepartmentCode(data.step_2.documentDepartmentCode);
    new MethodsStep_2(driver,wait).clickNext();
  }

  @Test(priority = 6)
  @Description("Шаг-3 Документ об образовании")
  @Severity(SeverityLevel.CRITICAL)
  public void step_3() {
    new MainStep_3(driver, wait).fillStep_3();
  }

  @Test(priority = 7)
  @Description("Шаг-4 Параметры специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void step_4() {
    new MainStep_4(driver, wait).fillStep_4();
  }

  @Test(priority = 8)
  @Description("Шаг-5")
  @Severity(SeverityLevel.CRITICAL)
  public void step_5() {
    new MainStep_5(driver, wait).fillStep_5();
  }

  @Test(priority = 9)
  @Description("Шаг-6 Специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void step_6() {
    new MainStep_6(driver, wait).fillStep_6();
  }

  @Test(priority = 10)
  @Description("Шаг-7 Особые условия при поступлении")
  @Severity(SeverityLevel.CRITICAL)
  public void step_7() {
    new MainStep_7(driver, wait).fillStep_7();
  }

  @Test(priority = 11)
  @Description("Шаг-8 Данные о законном представителе")
  @Severity(SeverityLevel.CRITICAL)
  public void step_8() {
    new MainStep_8(driver, wait).fillStep_8();
  }

  @Test(priority = 12)
  @Description("Проверка на всплывающий popUp")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver,wait,softAssert).assertPopUpContainsText(PopUpMessages.STATEMENT_CREATED);
    softAssert.assertAll();
    Thread.sleep(5000);
  }

  @Test(priority = 13)
  @Description("Переход к регистрации заявления")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateRegistrationApplication() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/ul/li[1]/a"))).click();
  }

  @Test(priority = 14)
  @Description("Дубликат Шаг-1")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateStep_1() {
    new MethodsStep_1(driver,wait).fillApplicantLastname(data.step_1.lastName);
    new MethodsStep_1(driver,wait).fillApplicantName(data.step_1.name);
    new MethodsStep_1(driver,wait).fillApplicantPatronymic(data.step_1.patronymic);
    new MethodsStep_1(driver,wait).fillApplicantBirthdate(data.step_1.birthDate);
    new MethodsStep_1(driver,wait).fillApplicantGender();
    new MethodsStep_1(driver,wait).fillApplicantBirthPlace(data.step_1.birthPlace);
    new MethodsStep_1(driver,wait).fillApplicantBirthAddress(data.step_1.address);
    new MethodsStep_1(driver,wait).fillApplicantIndex(data.step_1.index);
    driver.findElement(APPLICANT_SNILS).sendKeys(CheckDuplicateStatement.snils);
    new MethodsStep_1(driver,wait).fillApplicantPhone(data.step_1.phone);
    new MethodsStep_1(driver,wait).clickNext();
  }

  @Test(priority = 15)
  @Description("Дубликат Шаг-2 Тип документа")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateStep_2() {
    new MethodsStep_2(driver,wait).fillTypeOfDocument();
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_SERIES)).sendKeys(CheckDuplicateStatement.series);
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_NUMBER)).sendKeys(CheckDuplicateStatement.number);
    new MethodsStep_2(driver,wait).fillDocumentIssued(data.step_2.documentIssued);
    new MethodsStep_2(driver,wait).fillDocumentIssueDate(data.step_2.documentIssueDate);
    new MethodsStep_2(driver,wait).fillDocumentDepartmentCode(data.step_2.documentDepartmentCode);
    new MethodsStep_2(driver,wait).clickNext();
  }

  @Test(priority = 16)
  @Description("Дубликат Шаг-3 Документ об образовании")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateStep_3() {
   new MainStep_3(driver, wait).fillStep_3();
  }

  @Test(priority = 17)
  @Description("Дубликат Шаг-4 Параметры специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateStep_4() {
    new MainStep_4(driver, wait).fillStep_4();
  }

  @Test(priority = 18)
  @Description("Дубликат Шаг-5")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicateStep_5() {
    new MainStep_5(driver, wait).fillStep_5();
  }

  @Test(priority = 19)
  @Description("Проверка дубликата")
  @Severity(SeverityLevel.CRITICAL)
  public void duplicate() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(2000);
    String fieldHint = "Найдено ранее поданное заявление на выбранную специальность. Вы можете перейти к дубликату для просмотра";

    String pageSource = driver.getPageSource();

    softAssert.assertNotNull(pageSource);
    softAssert.assertTrue(pageSource.contains(fieldHint), "❌ Ожидалась подсказка: " + fieldHint);
    softAssert.assertAll();
  }
}
