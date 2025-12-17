/**
 * Класс очистки полей первого шага регистрации
 */

package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static tests.registration.registrationClassic.steps.step_1.Locators.*;

public class ClearFieldsStep_1 {

  WebDriver driver;
  WebDriverWait wait;

  public ClearFieldsStep_1(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void clearFieldsStep_1() {
    try {
      clearApplicantLastName();
      clearApplicantName();
      clearApplicantPatronymic();
      clearApplicantBirthdate();
      clearApplicantGender();
      clearApplicantEmail();
      clearApplicantBirthPlace();
      clearApplicantAddress();
      clearApplicantIndex();
      clearApplicantSnils();
      clearApplicantPhone();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Шаг 1: Ошибка при очистке одного из полей: " + e.getMessage());
    }
  }

  public void clearApplicantLastName() {
    WebElement applicantLastName = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_LASTNAME));
    applicantLastName.click();
    applicantLastName.sendKeys("test");
    applicantLastName.clear();
  }

  public void clearApplicantPatronymic() {
    WebElement applicantPatronymic = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_PATRONYMIC));
    applicantPatronymic.click();
    applicantPatronymic.sendKeys("test");
    applicantPatronymic.clear();
  }

  public void clearApplicantName() {
    WebElement applicantName = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_NAME));
    applicantName.click();
    applicantName.sendKeys("test");
    applicantName.clear();
  }

  public void clearApplicantBirthdate() throws InterruptedException {
    WebElement applicantBirthdate = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_BIRTH_DATE));
    applicantBirthdate.click();
    applicantBirthdate.sendKeys("12.12.2012" + Keys.ENTER);
    applicantBirthdate.clear();
  }

  public void clearApplicantGender() {
    try {
      WebElement applicantGenderClose = wait.until(
        ExpectedConditions.elementToBeClickable(By.className("select2-selection__clear"))
      );
      applicantGenderClose.click();
    } catch (TimeoutException e) {}
  }

  public void clearApplicantEmail() {
    WebElement applicantEmail = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_EMAIL));
    applicantEmail.click();
    applicantEmail.sendKeys("test");
    applicantEmail.clear();
  }

  public void clearApplicantBirthPlace() {
    WebElement applicantBirthplace = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_BIRTH_PLACE));
    applicantBirthplace.click();
    applicantBirthplace.sendKeys("test");
    applicantBirthplace.clear();
  }

  public void clearApplicantAddress() {
    WebElement applicantAddress = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_BIRTH_ADDRESS));
    applicantAddress.click();
    applicantAddress.sendKeys("test");
    applicantAddress.clear();
  }

  public void clearApplicantIndex() {
    WebElement applicantIndex = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_INDEX));
    applicantIndex.click();
    applicantIndex.sendKeys("test");
    applicantIndex.clear();
  }

  public void clearApplicantSnils() {
    WebElement applicantSnils = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_SNILS));
    applicantSnils.click();
    applicantSnils.sendKeys("test");
    applicantSnils.clear();
  }

  public void clearApplicantPhone() {
    WebElement applicantPhone = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_PHONE));
    applicantPhone.click();
    applicantPhone.sendKeys("test");
    applicantPhone.clear();
  }
}
