package tests.registration.registrationComparisonFields.steps.step_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_4.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_4.Expected.*;

public class MainAssertStep_4 extends BaseSteps {

  public MainAssertStep_4(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;

  }

  public void fillAssertStep_4() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);

    // Переход по вкладке "Информация об учреждении СПО и специальностях"
    WebElement TabInfoSVE = driver.findElement(By.id("custom-content-above-view-statement-tab"));
    TabInfoSVE.click();

    Thread.sleep(2000);

    assertUtils.assertElementTextEquals(ORGANIZATION_SVE_FIELD, expectedSPOOrganisation, "❌ Параметры специальности - поле: 'Наименование организации'");
    assertUtils.assertElementTextEquals(EDUCATION_LEVEL_FIELD, expectedEducationLevel, "❌ Параметры специальности - поле: 'Уровень образования'");
  }
}
