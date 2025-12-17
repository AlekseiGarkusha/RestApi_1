package tests.registration.registrationClassic.steps.step_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_4.Locators.*;

public class MainStep_4 extends BaseSteps {

  private final MethodsStep_4 methodsStep_4;

  public MainStep_4(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_4 = new MethodsStep_4(driver, this.wait);
  }

  public void fillStep_4() {
    String currentAction = "";

    try {
      currentAction = "ввод название специальности. Локатор: " + SPO_ORGANISATION;
      methodsStep_4.fillSPOOrganisation(data.step_4.spoOrganisation);

      currentAction = "ввод уровень образования. Локатор: " + EDUCATION_LEVEL;
      methodsStep_4.fillEducationLevel(data.step_4.educationLevel);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_4;
      methodsStep_4.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 4: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
