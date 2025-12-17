package tests.registration.registrationClassic.steps.step_7;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;
import java.util.List;

import static tests.registration.registrationClassic.steps.step_7.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_7.Expected.expectedIndividualAchievementsScore_1;

public class MethodsStep_7 extends BaseSteps {

  public MethodsStep_7(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  // == Справка об инвалидности ==
  public void fillSpecialConditionsFormDropdown() {
    wait.until(ExpectedConditions.elementToBeClickable(SELECT_SPECIAL_CONDITIONS_FORM_DROPDOWN)).click();
  }

  public void fillSpecialConditionsFormSerial(String series) {
    driver.findElement(SPECIAL_CONDITIONS_FORM_SERIAL).sendKeys(series);
  }

  public void fillSpecialConditionsFormNumber(String number) {
    driver.findElement(SPECIAL_CONDITIONS_FORM_NUMBER).sendKeys(number);
  }

  public void fillSpecialConditionsFormGroup(String group) {
    driver.findElement(SPECIAL_CONDITIONS_FORM_GROUP).sendKeys(group);
  }

  public void fillSpecialConditionsFormReason(String reason) {
    driver.findElement(SPECIAL_CONDITIONS_FORM_REASON).sendKeys(reason);
  }

  public void fillSpecialConditionsFormIssued(String issued) {
    driver.findElement(SPECIAL_CONDITIONS_FORM_ISSUED).sendKeys(issued);
  }

  public void fillSpecialConditionsFormIssueDate(String issueDate) {
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_FORM_ISSUE_DATE))
      .sendKeys(issueDate + Keys.ENTER);
  }

  public void fillSpecialConditionsFormExpirationDate(String expirationDate) {
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_FORM_EXPIRATION_DATE))
      .sendKeys(expirationDate + Keys.ENTER);
  }

  // == Льгота ==
  public void clickBenefit() {
    wait.until(ExpectedConditions.elementToBeClickable(SELECT_BENEFITS)).click();
  }

  public void fillBenefit_1() {
    wait.until(ExpectedConditions.elementToBeClickable(BENEFITS_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_1)).click();
  }
  public void fillBenefit_2() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_2)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_2)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_2)).click();
  }
  public void fillBenefit_3() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_3)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_3)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_3)).click();
  }
  public void fillBenefit_4() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_4)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_4)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_4)).click();
  }
  public void fillBenefit_5() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_5)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_5)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_5)).click();
  }
  public void fillBenefit_6() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_6)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_6)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_6)).click();
  }
  public void fillBenefit_7() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_7)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_7)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_7)).click();
  }
  public void fillBenefit_8() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_8)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_8)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_8)).click();
  }
  public void fillBenefit_9() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_9)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_9)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_9)).click();
  }
  public void fillBenefit_10() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_BENEFIT_TEMPLATE_10)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_DROPDOWN_ROW_10)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BENEFIT_LIST_ITEM_10)).click();
  }
  // == Справка по форме 086/у ==

  public void clickReference() {
    wait.until(ExpectedConditions.elementToBeClickable(SELECT_REFERENCE_086U)).click();
  }

  public void fillReferenceSeries(String series) {
    driver.findElement(REFERENCE_086U_SERIES).clear();
    driver.findElement(REFERENCE_086U_SERIES).sendKeys(series);
  }

  public void fillReferenceNumber(String number) {
    driver.findElement(REFERENCE_086U_NUMBER).clear();
    driver.findElement(REFERENCE_086U_NUMBER).sendKeys(number);
  }

  public void fillReferenceDate(String date) {
    wait.until(ExpectedConditions.elementToBeClickable(REFERENCE_086U_DATE)).sendKeys(date + Keys.ENTER);
  }
  // == Расширенная медицинская справка ==
  public void addExtendedMedicalCertificate() {
    wait.until(ExpectedConditions.elementToBeClickable(EXTENDED_MEDICAL_CERTIFICATE)).click();
  }

  // == Имеется заключение психолого-медико-педагогической комиссии ==
  public void addConclusion_PMPK() {
    wait.until(ExpectedConditions.elementToBeClickable(CONCLUSION_PMPK)).click();
  }

  // == Имеется потребность в специальных условиях при прохождении ВИ ==
  public void addSpecialConditions(){
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS)).click();
  }

  public void fillSpecialConditions_1( ){
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_1)).click();
  }

  public void fillSpecialConditions_2(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_SPECIAL_CONDITIONS_2)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN_2)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_2)).click();
  }
  public void fillSpecialConditions_3(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_SPECIAL_CONDITIONS_3)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN_3)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_3)).click();
  }
  public void fillSpecialConditions_4(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_SPECIAL_CONDITIONS_4)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN_4)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_4)).click();
  }
  public void fillSpecialConditions_5(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_SPECIAL_CONDITIONS_5)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN_5)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_5)).click();
  }
  public void fillSpecialConditions_6(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_SPECIAL_CONDITIONS_6)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_DROPDOWN_6)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_6)).click();
  }

  // == Имеется потребность в общежитии ==
  public void addDormitory(){
    wait.until(ExpectedConditions.elementToBeClickable(ADD_DORMITORY)).click();
  }

  // == Имеются индивидуальные достижения ==

  public void addIndividualAchievements() {
    wait.until(ExpectedConditions.elementToBeClickable(ADD_INDIVIDUAL_ACHIEVEMENTS)).click();
  }

  public void fillIndividualAchievement_1 () {
    // 1
    wait.until(ExpectedConditions.elementToBeClickable(INDIVIDUAL_ACHIEVEMENTS_DROPDOWN_1)).click();
    wait.until(ExpectedConditions.elementToBeClickable(INDIVIDUAL_ACHIEVEMENTS_1)).click();

  }

  public void fillIndividualAchievement_1_score (String score_1) {
    // Оценка ИД (проверка если нет оценки)
    List<WebElement> achievementScore = driver.findElements(INDIVIDUAL_ACHIEVEMENTS_SCORE_1);
    if (!achievementScore.isEmpty()) {
      WebElement input = achievementScore.get(0);
      input.sendKeys(expectedIndividualAchievementsScore_1);
    };
    driver.findElement(NEXT_BUTTON_STEP_7).click();

//    wait.until(ExpectedConditions.elementToBeClickable(INDIVIDUAL_ACHIEVEMENTS_SCORE_1)).sendKeys(score_1);
  }

  public void clickNext() {
    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_7)).click();
  }

}




