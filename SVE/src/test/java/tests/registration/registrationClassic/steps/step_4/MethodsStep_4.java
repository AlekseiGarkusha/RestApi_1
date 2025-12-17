package tests.registration.registrationClassic.steps.step_4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static tests.registration.registrationClassic.steps.step_4.Locators.*;

public class MethodsStep_4 {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public MethodsStep_4(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillSPOOrganisation(String spoOrganisation) {
    wait.until(ExpectedConditions.elementToBeClickable(SPO_ORGANISATION)).sendKeys(spoOrganisation + Keys.ENTER);
  }

  public void fillEducationLevel(String educationLevel) {
    wait.until(ExpectedConditions.elementToBeClickable(EDUCATION_LEVEL)).sendKeys(educationLevel + Keys.ENTER);
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_4).click();
  }
}
