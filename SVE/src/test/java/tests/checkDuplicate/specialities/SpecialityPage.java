package tests.checkDuplicate.specialities;

import data.TestDataRegistration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.random.GenerateDate;
import utils.JsonUtils;

import java.time.Duration;

import static tests.checkDuplicate.specialities.LocatorsCheckDuplicateSpecialities.*;

public class SpecialityPage {

  WebDriver driver;
  WebDriverWait wait;
  TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public SpecialityPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void fillSpecialityPage() {
    try {
      fillOrganizationName(data.specialityPage.SPOOrganisationName);
      choiceSpecialityName();
      fillApplicationStartDate();
      fillSpecialtiesEndDateTime();
      fillSPO_SpecialtiesEndDateTimeAgreed();
      fillBasicEducationLevel();
      fillFormOfStudy();
      FormOfPayment();
      fillNumberOfReceptionPlaces(data.specialityPage.numberOfReceptionPlaces);
      fillTermOfStudy(data.specialityPage.termOfStudy);
      fillEntranceExaminations();
      fillMedicalCertificate();
      fillProfileDisciplines();
      fillAdmissionEPGU();
      clickBtnSave();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Форма создания специальности, ошибка поля " + e.getMessage());
    }
  }

  public void fillOrganizationName(String name) {
    WebElement OrganizationName =
      wait.until(ExpectedConditions.elementToBeClickable(SELECT_ORGANIZATION_DROPDOWN));
    OrganizationName.sendKeys(name + Keys.ENTER);

  }

  public void choiceSpecialityName() {
    WebElement NameOfSpecialty =
      wait.until(ExpectedConditions.elementToBeClickable(CLICK_DROPDOWN_SPECIALTY));
    NameOfSpecialty.click();

    WebElement NameOfSpecialtyChoice = wait.until(ExpectedConditions.elementToBeClickable(SPECIALTY_NAME));
    NameOfSpecialtyChoice.click();
  }

  public void fillApplicationStartDate() {
    WebElement ApplicationStartDate = driver.findElement(APPLICATION_START_DATE);
    ApplicationStartDate.sendKeys(GenerateDate.getTodayDate());
  }

  public void fillSpecialtiesEndDateTime() {
    WebElement SpecialtiesEndDateTime = driver.findElement(APPLICATION_END_DATE);
    SpecialtiesEndDateTime.sendKeys(GenerateDate.getDateThreeMonthsFromNow());
  }

  public void fillSPO_SpecialtiesEndDateTimeAgreed() {
    WebElement SPO_SpecialtiesEndDateTimeAgreed =
      driver.findElement(APPLICATION_END_DATE_AGREED);
    SPO_SpecialtiesEndDateTimeAgreed.sendKeys(GenerateDate.getDateThreeMonthsFromNow());
  }

  public void fillBasicEducationLevel() {
    WebElement BasicEducationLevel = driver.findElement(BASIC_EDUCATION_LEVEL);
    BasicEducationLevel.click();
    BasicEducationLevel.sendKeys(Keys.ENTER);
  }

  public void fillFormOfStudy() {
    WebElement FormOfStudy = driver.findElement(FORM_OF_STUDY);
    FormOfStudy.click();
    FormOfStudy.sendKeys(Keys.ENTER);
  }

  public void FormOfPayment() {
    WebElement FormOfPayment =
      driver.findElement(FORM_OF_PAYMENT);
    FormOfPayment.click();
    FormOfPayment.sendKeys(Keys.ENTER);
  }

  public void fillNumberOfReceptionPlaces(String place) {
    WebElement NumberOfReceptionPlaces = driver.findElement(NUMBER_OF_PLACES);
    NumberOfReceptionPlaces.sendKeys(place);
  }

  public void fillTermOfStudy(String durationTraining) {
    WebElement DurationOfTraining = driver.findElement(TERM_OF_STUDY);
    DurationOfTraining.sendKeys(durationTraining);
  }

  public void fillEntranceExaminations() {
    WebElement EntranceExaminations = driver.findElement(ENTRANCE_EXAMINATIONS);
    EntranceExaminations.click();
  }

  public void fillMedicalCertificate() {
    WebElement MedicalCertificate = driver.findElement(MEDICAL_CERTIFICATE);
    MedicalCertificate.click();
  }

  public void fillProfileDisciplines() {
    WebElement ProfileDisciplines = driver.findElement(PROFILE_DISCIPLINES);
    ProfileDisciplines.click();
  }

  public void fillAdmissionEPGU() {
    WebElement AdmissionEPGU = driver.findElement(ADMISSION_EPGU);
    AdmissionEPGU.click();
  }

  public void clickBtnSave() {
    WebElement BtnSave = driver.findElement(SAVE_BUTTON);
    BtnSave.click();
  }
}
