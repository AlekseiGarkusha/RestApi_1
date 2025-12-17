package tests.registration.registrationClassic.steps.step_1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_1.Locators.*;
import static tests.registration.registrationClassic.steps.step_1.MainStep_1.Snils;

public class MethodsStep_1 extends BaseSteps {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public MethodsStep_1(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillApplicantLastname(String surname) {
    driver.findElement(APPLICANT_LASTNAME).sendKeys(surname);
  }

  public void fillApplicantName(String name) {
    driver.findElement(APPLICANT_NAME).sendKeys(name);
  }

  public void fillApplicantPatronymic(String patronymic) {
    driver.findElement(APPLICANT_PATRONYMIC).sendKeys(patronymic);
  }

  public void fillApplicantBirthdate(String applicantBirthdate) {
    driver.findElement(APPLICANT_BIRTH_DATE).sendKeys(applicantBirthdate + Keys.ENTER);
  }

  public void fillApplicantGender() {
    wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_GENDER_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_GENDER)).click();
  }

  public void fillApplicantEmail(String email) {
    driver.findElement(APPLICANT_EMAIL).sendKeys(email);
  }

  public void fillApplicantBirthPlace(String birthPlace) {
    driver.findElement(APPLICANT_BIRTH_PLACE).sendKeys(birthPlace);
  }

  public void fillApplicantBirthAddress(String birthAddress) {
    driver.findElement(APPLICANT_BIRTH_ADDRESS).sendKeys(birthAddress);
  }

  public void fillApplicantIndex(String index) {
    driver.findElement(APPLICANT_INDEX).sendKeys(index);
  }

  public void fillApplicantSnils(String snils) {
    driver.findElement(APPLICANT_SNILS).sendKeys(Snils);
  }

  public void fillApplicantPhone(String phone) {
    driver.findElement(APPLICANT_PHONE).sendKeys(phone);
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_1).click();
  }
}
