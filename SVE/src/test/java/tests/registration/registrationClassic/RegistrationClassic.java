/**
 * (Добавить в Intellij Idea Плагин - TestNG)
 * Позитивный тест регистрации заявления
 * Проходится по всем полям.
 * В методе auth, в классе Base, в "@Test - Авторизация" -  логин и пароль для авторизации.
 */

package tests.registration.registrationClassic;

import data.GeneratedTestData;
import data.PopUpMessages;

import data.TestDataRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.Setup;
import tests.registration.registrationClassic.steps.step_1.MainStep_1;
import tests.registration.registrationClassic.steps.step_2.MainStep_2;
import tests.registration.registrationClassic.steps.step_3.MainStep_3;
import tests.registration.registrationClassic.steps.step_4.MainStep_4;
import tests.registration.registrationClassic.steps.step_5.MainStep_5;
import tests.registration.registrationClassic.steps.step_6.MainStep_6;
import tests.registration.registrationClassic.steps.step_7.MainStep_7;
import tests.registration.registrationClassic.steps.step_8.MainStep_8;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import utils.ClearFieldsStep_1;
import utils.JsonUtils;
import utils.PopUpUtils;
import utils.ScreenshotUtil;

import java.time.Duration;

public class RegistrationClassic {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected TestDataRegistration data;

  @BeforeClass
  public void beforeClass() {
    Setup setup = new Setup();
    driver = setup.getDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    setup.openPage("https://beta.rkspo.ru/user/login");
    data = JsonUtils.readTestData("TestData.json");

    GeneratedTestData.generateGrades();
  }

  @AfterMethod
  public void takeScreenshotOnFailure(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      String fileName = result.getName() + "_" + System.currentTimeMillis();
      ScreenshotUtil.takeScreenshot(driver, fileName);
    }
  }

  @AfterClass
  public void tearDown() {
    Setup.closeBrowser();
  }

  @Test(priority = 1, description = "Авторизация")
  @Description("Авторизация")
  @Severity(SeverityLevel.CRITICAL)
  public void auth() {
    new Auth(driver, wait).login (
      "AutotestAdmin000",
      "AutotestAdmin000!");
  }

  @Test(priority = 2)
  @Description("Переход к регистрации заявления")
  @Severity(SeverityLevel.CRITICAL)
  public void registrationApplication() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/a"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/ul/li[1]/a"))).click();
  }

  @Test(priority = 3)
  @Description("Очистка полей")
  @Severity(SeverityLevel.TRIVIAL)
  public void clearFields() {
    new ClearFieldsStep_1(driver, wait).clearFieldsStep_1();
  }

  @Test(priority = 4)
  @Description("Шаг-1")
  @Severity(SeverityLevel.CRITICAL)
  public void step_1() {
   new MainStep_1(driver, wait).fillStep_1();
  }

  @Test(priority = 5)
  @Description("Шаг-2 Тип документа")
  @Severity(SeverityLevel.CRITICAL)
  public void step_2() {
   new MainStep_2(driver, wait).fillStep_2();
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
  @Description("Проверка на всплывающий popUp с softAssert")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.STATEMENT_CREATED);
    softAssert.assertAll();
  }
}
