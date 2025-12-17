/** Тест позитивный кейс -  создание группы ВИ */

package tests.adminOO.addGroupsEntranceExams;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import tests.adminOO.addGroupsEntranceExams.main.Main;
import utils.PopUpUtils;
import utils.random.GenerateDate;

import static tests.adminOO.addEntranceExams.Locators.SCHEDULE_ENTRANCE_TEST_MENU;
import static tests.adminOO.addGroupsEntranceExams.main.Locators.*;

public class AddGroupEntranceExams extends Base {

  @Test(priority = 2)
  @Description("Переход к реестру ВИ и карточке ВИ")
  @Severity(SeverityLevel.CRITICAL)
  public void goToRegistryEntranceExams() {
    wait.until(ExpectedConditions.elementToBeClickable(SCHEDULE_ENTRANCE_TEST_MENU)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ENTRANCE_EXAMS_MENU)).click();
    wait.until(ExpectedConditions.elementToBeClickable(VIEW_CARD_ENTRANCE_EXAMS)).click();
  }

  public void time() {
    System.out.println(GenerateDate.getDateThreeMonthsFromNow());
  }

  @Test(priority = 3)
  @Description("Добавление группы ВИ")
  @Severity(SeverityLevel.CRITICAL)
  public void addGroupEntranceExams() {
    new Main(driver, wait).fillFieldsGroupEntranceExam();
  }

  @Test(priority = 20)
  @Description("Проверка на всплывающий popUp")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.EXAM_GROUP_CREATED);
    softAssert.assertAll();
  }
}
