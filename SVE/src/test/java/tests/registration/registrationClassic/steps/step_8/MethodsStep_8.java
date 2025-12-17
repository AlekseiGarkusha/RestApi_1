package tests.registration.registrationClassic.steps.step_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_8.Locators.*;

public class MethodsStep_8 extends BaseSteps {

  public MethodsStep_8(WebDriver driver, WebDriverWait wait){
    this.driver = driver;
    this.wait = wait;
  }

  public void fillFio(String fio) {
    wait.until(ExpectedConditions.elementToBeClickable(LEGAL_REPRESENTATIVE_FIO)).sendKeys(fio);
  }

  public void fillPhone(String phone) {
    driver.findElement(LEGAL_REPRESENTATIVE_PHONE).sendKeys(phone);
  }

  public void fillEmail(String email) {
    driver.findElement(LEGAL_REPRESENTATIVE_EMAIL).sendKeys(email);
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_FINISH).click();
  }
}
