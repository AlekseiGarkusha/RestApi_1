package tests.registration.registrationComparisonFields.steps.step_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;
import utils.AssertUtils;

import static tests.registration.registrationComparisonFields.steps.step_8.Locators.*;
import static tests.registration.registrationComparisonFields.steps.step_8.Expected.*;

public class MainAssertStep_8 extends BaseSteps {

  public MainAssertStep_8(WebDriver driver,
                          WebDriverWait wait,
                          SoftAssert softAssert) {
    this.driver = driver;
    this.wait = wait;
    this.softAssert = softAssert;
  }

  public void fillAssertStep_8() throws InterruptedException {
    AssertUtils assertUtils = new AssertUtils(driver,wait, softAssert);
    // Переход на таб Родитель (Законный представитель)
    driver.findElement(By.id("custom-content-above-view-legal-representative-tab")).click();

    Thread.sleep(5000);

    assertUtils.assertElementTextEquals(LEGAL_REPRESENTATIVE_FIO_FIELD, expectedLegalRepresentativeFio, "❌ Ошибка соответствия - Законный представитель - поле: 'ФИО'");
    assertUtils.assertElementTextEquals(LEGAL_REPRESENTATIVE_PHONE_FIELD, "+7 " + expectedLegalRepresentativePhone, "❌ Ошибка соответствия - Законный представитель - поле: 'Телефон'");
    assertUtils.assertElementTextEquals(LEGAL_REPRESENTATIVE_EMAIL_FIELD, expectedLegalRepresentativeEmail, "❌ Ошибка соответствия - Законный представитель - поле: 'Email'");
  }
}
