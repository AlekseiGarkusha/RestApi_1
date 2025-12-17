package tests.registration.registrationComparisonFields.steps.step_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_7.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_7.Expected.*;

public class MainAssertStep_7 extends BaseSteps {

  public MainAssertStep_7(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert =softAssert;
  }

  public void fillAssertStep_7() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);

    // Переход по вкладке  Документ, подтверждающий инвалидность
    driver.findElement(By.id("custom-content-above-view-certificate-disability-tab")).click();
    Thread.sleep(3000);
    // =============== Справка об инвалидности ===========
    // Проверяем поля "Справка об инвалидности"
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_SERIAL_FIELD, expectedSpecialConditionsFormSerial, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'Серия'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_NUMBER_FIELD, expectedSpecialConditionsFormNumber, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'Номер'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_GROUP_FIELD, expectedSpecialConditionsFormGroup, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'Группа инвалидности'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_REASON_FIELD, expectedSpecialConditionsFormReason, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'Причина'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_ORGANIZATION_FIELD, expectedSpecialConditionsFormIssued, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'Наименование организации'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_DATE_START_FIELD, expectedSpecialConditionsFormIssueDate, "❌ Ошибка соответствия - Справка об инвалидности - поле: 'дата выдачи'");
    assertUtils.assertElementTextEquals(SPECIAL_CONDITIONS_FORM_EXPIRATION_DATE_FIELD, expectedSpecialConditionsFormExpirationDate,
"❌ Ошибка соответствия - Справка об инвалидности - поле: 'дата окончания'");

    // Переход на вкладку "Льготы"
    wait.until(ExpectedConditions.elementToBeClickable(By.id("custom-content-above-view-benefits-tab"))).click();

    // Проверяем льготы 1-10
    assertUtils.assertElementTextEquals(BENEFIT_1_FIELD, expectedBenefit_1, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 1'");
    assertUtils.assertElementTextEquals(BENEFIT_2_FIELD, expectedBenefit_2, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 2'");
    assertUtils.assertElementTextEquals(BENEFIT_3_FIELD, expectedBenefit_3, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 3'");
    assertUtils.assertElementTextEquals(BENEFIT_4_FIELD, expectedBenefit_4, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 4'");
    assertUtils.assertElementTextEquals(BENEFIT_5_FIELD, expectedBenefit_5, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 5'");
    assertUtils.assertElementTextEquals(BENEFIT_6_FIELD, expectedBenefit_6, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 6'");
    assertUtils.assertElementTextEquals(BENEFIT_7_FIELD, expectedBenefit_7, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 7'");
    assertUtils.assertElementTextEquals(BENEFIT_8_FIELD, expectedBenefit_8, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 8'");
    assertUtils.assertElementTextEquals(BENEFIT_9_FIELD, expectedBenefit_9, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 9'");
    assertUtils.assertElementTextEquals(BENEFIT_10_FIELD, expectedBenefit_10, "❌ Ошибка соответствия - Льгота - поле: 'Льгота 10'");

    // Переход на вкладку "Справка 086У"
    wait.until(ExpectedConditions.elementToBeClickable(By.id("custom-content-above-view-statement-tab"))).click();
    assertUtils.assertElementTextEquals(REFERENCE_086U_SERIES_FIELD, expectedReference_086USeries, "❌ Ошибка соответствия - Справка 086У - поле: 'Серия'");
    assertUtils.assertElementTextEquals(REFERENCE_086U_NUMBER_FIELD, expectedReference_086UNumber, "❌ Ошибка соответствия - Справка 086У - поле: 'Номер'");
    assertUtils.assertElementTextEquals(REFERENCE_086U_DATE_FIELD, expectedReference_086UDate + " 00:00", "❌ Ошибка соответствия - Справка 086У - поле: 'Дата'");

    // Переход на вкладку "Специальные условия ВИ"
    wait.until(ExpectedConditions.elementToBeClickable(By.id("custom-content-above-view-statement-tab"))).click();

    // Проверка специальный условий ВИ
    WebElement specialConditionsVI = wait.until(ExpectedConditions.elementToBeClickable(SPECIAL_CONDITIONS_VI_FIELD));
    String ActualSPECIAL_CONDITIONS_VI_FIELD = specialConditionsVI.getText();
    Assert.assertEquals(
      "[" + ActualSPECIAL_CONDITIONS_VI_FIELD + "]",
      expectedConditions,
      "❌ Ошибка соответствия - Специальные условия ВИ - поле: 'условия'");

    // Переход на вкладку "Индивидуальные достижения"
    wait.until(ExpectedConditions.elementToBeClickable(By.id("custom-content-above-view-personal-achievement-tab"))).click();
    assertUtils.assertElementTextEquals(INDIVIDUAL_ACHIEVEMENTS_FIELD, expectedIndividualAchievements, "❌ Ошибка соответствия - Индивидуальные достижения - поле: 'ИД'");
    assertUtils.assertElementTextEquals(INDIVIDUAL_ACHIEVEMENTS_SCORE_FIELD,  expectedIndividualAchievementsScore_1, "❌ Ошибка соответствия - Индивидуальные достижения - поле: 'Оценка'");
  }
}
