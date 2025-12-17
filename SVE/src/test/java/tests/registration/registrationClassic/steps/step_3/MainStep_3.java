package tests.registration.registrationClassic.steps.step_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import data.GeneratedTestData;
import org.testng.Assert;
import setup.BaseSteps;

import static tests.registration.registrationClassic.steps.step_3.Locators.*;

public class MainStep_3 extends BaseSteps {

  private final MethodsStep_3 methodsStep_3;

  public MainStep_3(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_3 = new MethodsStep_3(driver, this.wait);
  }

  public void fillStep_3() {
    String currentAction = "";

    try {
      currentAction = "выбор кода документа об образовании. Локатор: " + EDUCATION_DOCUMENT_CODE_OPTION;
      methodsStep_3.fillEducationDocumentCodeOption();

      currentAction = "ввод организации, выдавшей документ. Локатор: " + EDUCATION_DOCUMENT_ISSUED;
      methodsStep_3.fillEducationIssued(data.step_3.educationDocumentIssued);

      currentAction = "ввод серии документа. Локатор: " + EDUCATION_DOCUMENT_SERIES;
      methodsStep_3.fillEducationSeries(data.step_3.educationDocumentSeries);

      currentAction = "ввод номера документа. Локатор: " + EDUCATION_DOCUMENT_NUMBER;
      methodsStep_3.filEducationNumber(data.step_3.educationDocumentNumber);

      currentAction = "ввод даты выдачи документа. Локатор: " + EDUCATION_DOCUMENT_ISSUE_DATE;
      methodsStep_3.fillEducationIssueDate(data.step_3.educationDocumentIssueDate);

      currentAction = "клик по ,бинарной кнопке (С отличием). Локатор: " + EDUCATION_DOCUMENT_WITH_DIFFERENCE;
      methodsStep_3.clickEducationWithDifference();

      currentAction = "клик по ,бинарной кнопке (Получение СПО в первые). Локатор: " + EDUCATION_DOCUMENT_RECEIVING_SPO_FIRST_TIME;
      methodsStep_3.clickBinaryReceivingSPOFirstTime();

      currentAction = "ввод оценки - 5. Локатор: " + EDUCATION_DOCUMENT_NUMBER_FIVES;
      methodsStep_3.fillEducationNumberFives(GeneratedTestData.gradeFives);

      currentAction = "ввод оценки - 4. Локатор: " + EDUCATION_DOCUMENT_NUMBER_FOURS;
      methodsStep_3.fillEducationNumberFours(GeneratedTestData.gradeFours);

      currentAction = "Ввод оценки - 3. Локатор: " + EDUCATION_DOCUMENT_NUMBER_THREES;
      methodsStep_3.fillEducationNumberThrees(GeneratedTestData.gradeThrees);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_3;
      methodsStep_3.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 3: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
