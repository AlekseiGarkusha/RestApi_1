package tests.registration.registrationClassic.steps.step_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_6.Locators.*;

public class MainStep_6 extends BaseSteps {

  private final MethodsStep_6 methodsStep_6;

  public MainStep_6(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_6 = new MethodsStep_6(driver, this.wait);
  }

  public void fillStep_6() {
    String currentAction = "";

    try {
      currentAction = "ввод оценки по математике. Локатор: " + MATHEMATICS_SCORE;
      methodsStep_6.fillMathematicsScore(data.step_6.mathematics);

      currentAction = "ввод оценки по информатике. Локатор: " + COMPUTER_SCIENCE_SCORE;
      methodsStep_6.fillComputerScienceScore(data.step_6.computerScience);

      currentAction = "ввод оценки по физике. Локатор: " + PHYSICS_SCORE;
      methodsStep_6.fillPhysicsScore(data.step_6.physics);

      currentAction = "ввод оценки по географии. Локатор: " + GEOGRAPHY_SCORE;
      methodsStep_6.fillGeographyScore(data.step_6.geography);

      currentAction = "ввод оценки по китайскому языку. Локатор: " + CHINESE_SCORE;
      methodsStep_6.fillChineseScore(data.step_6.chinese);

      currentAction = "ввод оценки по литературе. Локатор: " + LITERATURE_SCORE;
      methodsStep_6.fillLiteratureScore(data.step_6.literature);

      currentAction = "ввод оценки по испанскому языку. Локатор: " + SPANISH_SCORE;
      methodsStep_6.fillSpanishScore(data.step_6.spanish);

      currentAction = "ввод оценки по немецкому языку. Локатор: " + GERMAN_SCORE;
      methodsStep_6.fillGermanScore(data.step_6.german);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_6;
      methodsStep_6.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 6: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
