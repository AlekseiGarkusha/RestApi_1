package tests.registration.registrationClassic.steps.step_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_6.Locators.*;

public class MethodsStep_6 extends BaseSteps {

  public MethodsStep_6(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillMathematicsScore(String mathematics) {
    wait.until(ExpectedConditions.elementToBeClickable(MATHEMATICS_SCORE)).sendKeys(mathematics);
  }

  public void fillComputerScienceScore(String computerScience) {
    driver.findElement(COMPUTER_SCIENCE_SCORE).sendKeys(computerScience);
  }

  public void fillPhysicsScore(String physics) {
    driver.findElement(PHYSICS_SCORE).sendKeys(physics);
  }

  public void fillGeographyScore(String geography) {
    driver.findElement(GEOGRAPHY_SCORE).sendKeys(geography);
  }

  public void fillChineseScore(String chinese) {
    driver.findElement(CHINESE_SCORE).sendKeys(chinese);
  }

  public void fillLiteratureScore(String literature) {
    driver.findElement(LITERATURE_SCORE).sendKeys(literature);
  }

  public void fillSpanishScore(String spanish) {
    driver.findElement(SPANISH_SCORE).sendKeys(spanish);
  }

  public void fillGermanScore(String german) {
    driver.findElement(GERMAN_SCORE).sendKeys(german);
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_6).click();
  }
}
