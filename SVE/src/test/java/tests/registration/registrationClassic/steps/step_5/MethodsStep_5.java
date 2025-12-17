package tests.registration.registrationClassic.steps.step_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_5.Locators.*;

public class MethodsStep_5 extends BaseSteps {

  public MethodsStep_5(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillListSpecialties(String speciality) {
    wait.until(ExpectedConditions.elementToBeClickable(LIST_SPECIALITIES)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIALITY)).click();
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_5).click();
  }
}
