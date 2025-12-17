package tests.adminOO.changeApplicantData;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import utils.random.GenerateDate;

import static tests.adminOO.WIP_workingWithStatuses.Locators.*;
import static tests.adminOO.changeApplicantData.Locators.*;
import static tests.registration.registrationClassic.steps.step_1.Locators.*;

public class Methods extends BaseSteps {

  private final SoftAssert softAssert;

  public Methods(WebDriver driver, WebDriverWait wait, SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void openRegisterOfApplications () {
    wait.until(ExpectedConditions.elementToBeClickable(STATEMENTS_MENU)).click();
    wait.until(ExpectedConditions.elementToBeClickable(REGISTER_OF_APPLICATIONS)).click();
  }

  public void changeFilterStatusAccepted() {
    wait.until(ExpectedConditions.elementToBeClickable(FILTER_BY_STATUSES)).click();
    wait.until(ExpectedConditions.elementToBeClickable(FILL_STATUS_APPLICATION_ACCEPTED)).click();
  }

  public void changeFilterPersonalReception () {
    wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-applicationview-system_code-container"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='select2-results__option' and text()='Личный прием']"))).click();
  }

  public void openApplicationCard() {
    WebElement firstColumn = wait.until(ExpectedConditions.elementToBeClickable(OPEN_FIRST_APPLICATION_CARD));
    firstColumn.click();
  }

  public void clickChangeDataBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(CLICK_CHANGE_DATA_BTN)).click();
  }

  public void changeApplicantSurname() {
    WebElement applicantSurname = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_LASTNAME));
    applicantSurname.clear();
    applicantSurname.sendKeys(data.expectedData.expectedNewApplicantSurname);
  }

  public void changeApplicantName() {
    WebElement applicantName = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_NAME));
    applicantName.clear();
    applicantName.sendKeys(data.expectedData.expectedNewApplicantName);
  }

  public void changeApplicantPatronymic() {
    WebElement applicantPatronymic = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_PATRONYMIC));
    applicantPatronymic.clear();
    applicantPatronymic.sendKeys(data.expectedData.expectedNewApplicantPatronymic);
  }

  public String changeApplicantGender() {
    WebElement applicantGender = wait.until(ExpectedConditions.elementToBeClickable(NEW_APPLICANT_GENDER_DROPDOWN));
    applicantGender.click();

    if (applicantGender.getText().equals("мужской")) {
      wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_GENDER_FEMALE)).click();
      return "женский";
    } else {
      wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_GENDER_MALE)).click();
      return "мужской";
    }
  }

  public void changeApplicantBirthDate() {
    WebElement applicantBitchDate = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_BIRTH_DATE));
    applicantBitchDate.clear();
    applicantBitchDate.sendKeys(data.expectedData.expectedNewApplicantBirthDate);
  }

  public void changeApplicantBirthPlace() {
    WebElement applicantBitchPlace = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_BIRTH_PLACE));
    applicantBitchPlace.clear();
    applicantBitchPlace.sendKeys(data.expectedData.expectedNewApplicantBirthPlace);
  }

  public void changeApplicantIndex() {
    WebElement applicantIndex = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_INDEX));
    applicantIndex.clear();
    applicantIndex.sendKeys(data.expectedData.expectedNewApplicantIndex);
  }

  public void changeApplicantAddress() {
    WebElement applicantAddress = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_ADDRESS));
    applicantAddress.clear();
    applicantAddress.sendKeys(data.expectedData.expectedNewApplicantAddress);
  }

  public void changeApplicantSnils(String expectedNewSnils) {

    WebElement applicantSnils = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_SNILS));
    applicantSnils.clear();
    applicantSnils.sendKeys(expectedNewSnils);
  }

  public void changeApplicantEmail() {
    WebElement applicantEmail = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_EMAIL));
    applicantEmail.clear();
    applicantEmail.sendKeys(data.expectedData.expectedNewApplicantEmail);
  }

  public void changeApplicantPhone() {
    WebElement applicantPhone = wait.until(ExpectedConditions.elementToBeClickable(APPLICANT_PHONE));
    applicantPhone.clear();
    applicantPhone.sendKeys(data.expectedData.expectedNewApplicantPhone);
  }

  public void clickBtnChangesSave() {
    wait.until(ExpectedConditions.elementToBeClickable(CLICK_BTN_CHANGES_SAVE)).click();
  }

  // Как починят баг - заменить код
//  public void fillAssertApplicantData() throws InterruptedException {
//    AssertUtils assertUtils = new AssertUtils(driver, wait);
//    Thread.sleep(3000);
//    expectedNewSnils = GenerateRandomSnils.generateRandomSnils();
//
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_BIRTH_DATE, data.expectedData.expectedNewApplicantBirthDate, "Ошибка в изменении поля - Дата рождений");
//    assertUtils.assertElementTextEquals(NEW_ACTUAL_APPLICANT_BIRTH_PLACE, data.expectedData.expectedNewApplicantBirthPlace, "Ошибка в изменении поля - Место рождения");
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_INDEX,data.expectedData.expectedNewApplicantIndex, "Ошибка в изменении поля - Индекс");
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_ADDRESS,data.expectedData.expectedNewApplicantAddress, "Ошибка в изменении поля - адрес регистрации");
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_SNILS,expectedNewSnils, "Ошибка в изменении поля - снилс");
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_EMAIL,data.expectedData.expectedNewApplicantEmail, "Ошибка в изменении поля - email");
//    assertUtils.assertElementTextEquals(ACTUAL_APPLICANT_PHONE,"+7 (333)-333-33-33", "Ошибка в изменении поля - телефон");
//    assertUtils.assertElementTextEquals(ACTUAL_DATE_UPDATED,"+7 (333)-333-33-33", "Ошибка в изменении поля - телефон");
//
//    WebElement assertApplicantDateUpdate = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_DATE_UPDATED));
//    String dateUpdateGetText = assertApplicantDateUpdate.getText();
//    String[] dateUpdateSplit = dateUpdateGetText.split(" ");
//    String actualDateUpdate= dateUpdateSplit[0].toString();
//    Assert.assertEquals(actualDateUpdate, GenerateDate.getTodayDate(), "Ошибка в изменении поля - Обновлено");
//
//  }


  public void assertApplicantSurname() {
    WebElement actualApplicantSurname = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_SURNAME));
    softAssert.assertEquals(actualApplicantSurname.getText(), data.expectedData.expectedNewApplicantSurname, "Ошибка в изменении поля - Фамилия");
  }

  public void assertApplicantName() {
    WebElement actualApplicantSurname = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_NAME));
    softAssert.assertEquals(actualApplicantSurname.getText(), data.expectedData.expectedNewApplicantName, "Ошибка в изменении поля - Имя");
  }

  public void assertApplicantPatronymic() {
    WebElement actualApplicantPatronymic = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_PATRONYMIC));
    softAssert.assertEquals(actualApplicantPatronymic.getText(), data.expectedData.expectedNewApplicantPatronymic, "Ошибка в изменении поля - Отчество");
  }

  public void assertApplicantGender(String expectedGender) {

    // Получаем фактический пол из UI
    WebElement actualApplicantGender = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_GENDER));
    String actualGender = actualApplicantGender.getText();
    // Логика сравнения
    if ("мужской".equalsIgnoreCase(expectedGender)) {
      softAssert.assertEquals(actualGender, "мужской", "Ожидался пол 'мужской'");
    } else {
      softAssert.assertEquals(actualGender, "женский", "Ожидался пол 'женский'");
    }
  }

  public void assertApplicantBirthDate() {
    WebElement actualApplicantBirthDate = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_BIRTH_DATE));
    softAssert.assertEquals(actualApplicantBirthDate.getText(),data.expectedData.expectedNewApplicantBirthDate, "Ошибка в изменении поля - Дата рождений");
  }

  public void assertApplicantBirthPlace() {
    WebElement actualApplicantBirthPlace = wait.until(ExpectedConditions.elementToBeClickable(NEW_ACTUAL_APPLICANT_BIRTH_PLACE));
    softAssert.assertEquals(actualApplicantBirthPlace.getText(), data.expectedData.expectedNewApplicantBirthPlace, "Ошибка в изменении поля - Место рождения");
  }


  public void assertApplicantIndex() {
    WebElement actualApplicantIndex = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_INDEX));
    softAssert.assertEquals(actualApplicantIndex.getText(),data.expectedData.expectedNewApplicantIndex, "Ошибка в изменении поля - Индекс");
  }

  public void assertApplicantAddress() {
    WebElement actualApplicantAddress = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_ADDRESS));
    softAssert.assertEquals(actualApplicantAddress.getText(), data.expectedData.expectedNewApplicantAddress, "Ошибка в изменении поля - адрес регистрации");
  }

  public void assertApplicantSnils(String expectedNewSnils) {
    WebElement actualApplicantSnils = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_SNILS));
    softAssert.assertEquals(actualApplicantSnils.getText(), expectedNewSnils, "Ошибка в изменении поля - снилс");
  }

  public void assertApplicantEmail() {
    WebElement actualApplicantEmail = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_EMAIL));
    softAssert.assertEquals(actualApplicantEmail.getText(), data.expectedData.expectedNewApplicantEmail, "Ошибка в изменении поля - email");
  }

  public void assertApplicantPhone() {
    WebElement assertApplicantPhone = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_APPLICANT_PHONE));
    softAssert.assertEquals(assertApplicantPhone.getText(), "+7 (333)-333-33-33", "Ошибка в изменении поля - телефон");
  }

  public void assertApplicantDateUpdate() {
    WebElement assertApplicantDateUpdate = wait.until(ExpectedConditions.elementToBeClickable(ACTUAL_DATE_UPDATED));
    String dateUpdateGetText = assertApplicantDateUpdate.getText();
    String[] dateUpdateSplit = dateUpdateGetText.split(" ");
    String actualDateUpdate= dateUpdateSplit[0].toString();

    softAssert.assertEquals(actualDateUpdate, GenerateDate.getTodayDate(), "Ошибка в изменении поля - Обновлено");
  }
}
