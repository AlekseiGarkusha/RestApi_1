package tests.registration.registrationClassic.steps.step_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_8.Locators.*;

public class MainStep_8 extends BaseSteps {

  public final MethodsStep_8 methodsStep_8;

  public MainStep_8(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_8 = new MethodsStep_8(driver, wait);
  }

  public void fillStep_8() {
    String currentAction = "";

    try {
      currentAction = "ввод ФИО законного представителя. Локатор: " + LEGAL_REPRESENTATIVE_FIO;
      methodsStep_8.fillFio(data.step_8.legalRepresentative.fio);

      currentAction = "ввод телефона законного представителя. Локатор: " + LEGAL_REPRESENTATIVE_PHONE;
      methodsStep_8.fillPhone(data.step_8.legalRepresentative.phone);

      currentAction = "ввод email законного представителя. Локатор: " + LEGAL_REPRESENTATIVE_EMAIL;
      methodsStep_8.fillEmail(data.step_8.legalRepresentative.email);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_FINISH;
      methodsStep_8.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 8: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
