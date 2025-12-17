package tests.registration.registrationClassic.steps.step_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;
import utils.random.GenerateRandomNumber;
import utils.random.GenerateRandomSeries;
import java.time.Duration;
import static tests.registration.registrationClassic.steps.step_2.Locators.*;

public class MainStep_2 extends BaseSteps {

  public static String applicantDocumentSeries;
  public static String applicantDocumentNumber;
  private final MethodsStep_2 methodsStep_2;

  public MainStep_2(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.methodsStep_2 = new MethodsStep_2(driver, this.wait);
  }

  public void fillStep_2() {
    String currentAction = "";
    applicantDocumentSeries = GenerateRandomSeries.generateRandomSeries();
    applicantDocumentNumber = GenerateRandomNumber.generateRandomNumber();

    try {
      currentAction = "выбор типа документа. Локатор: " + DOCUMENT_TYPE;
      methodsStep_2.fillTypeOfDocument();

      currentAction = "ввод серии документа. Локатор: " + DOCUMENT_SERIES;
      methodsStep_2.fillDocumentSeries(applicantDocumentSeries);

      currentAction = "ввод номера документа. Локатор: " + DOCUMENT_NUMBER;
      methodsStep_2.fillDocumentNumber(applicantDocumentNumber);

      currentAction = "ввод выдавшей организации. Локатор: " + DOCUMENT_ISSUED;
      methodsStep_2.fillDocumentIssued(data.step_2.documentIssued);

      currentAction = "ввод даты выдачи документа. Локатор: " + DOCUMENT_ISSUE_DATE;
      methodsStep_2.fillDocumentIssueDate(data.step_2.documentIssueDate);

      currentAction = "ввод кода подразделения. Локатор: " + DOCUMENT_DEPARTMENT_CODE;
      methodsStep_2.fillDocumentDepartmentCode(data.step_2.documentDepartmentCode);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_2;
      methodsStep_2.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 2: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}

