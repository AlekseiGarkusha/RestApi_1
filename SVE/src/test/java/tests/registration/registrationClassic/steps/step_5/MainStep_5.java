package tests.registration.registrationClassic.steps.step_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_5.Locators.*;

public class MainStep_5 extends BaseSteps {

  private final MethodsStep_5 methodsStep_5;

  public MainStep_5(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_5 = new MethodsStep_5(driver, this.wait);
  }

  public void fillStep_5() {
    String currentAction = "";

    try {
      currentAction = "ввод специальности. Локатор: " + SPECIALITY;
      methodsStep_5.fillListSpecialties(data.step_5.speciality);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_5;
      methodsStep_5.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 5: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
