/**
 * Проверка на дубликат создания Специальности
 * Проверка реализована под ролью Супер-Администратор (В других ролях функционал заблокирован)
 */

package tests.checkDuplicate.specialities;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.Base;
import setup.BaseSuperAdmin;

import static tests.checkDuplicate.specialities.LocatorsCheckDuplicateSpecialities.*;

public class CheckDuplicateSpecialities extends BaseSuperAdmin {

  @Test(priority = 2)
  @Description("Переход в раздел специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void clickReceptionPlanMenu() {
    wait.until(ExpectedConditions.elementToBeClickable(MENU_RECEPTION_PLAN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SUBMENU_ADD_SPECIALTIES)).click();
  }

  @Test(priority = 3)
  @Description("Добавление специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void addSpecialty() {
    new SpecialityPage(driver, wait).fillSpecialityPage();
  }

  @Test(priority = 4)
  @Description("Проверка специальности")
  @Severity(SeverityLevel.CRITICAL)
  public void specialtyCheck() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(1000);

    String fieldHint = "В вашей организации уже создана специальность с такими параметрами.";
    String pageSource = driver.getPageSource();

    softAssert.assertNotNull(pageSource);
    softAssert.assertTrue(pageSource.contains(fieldHint), "❌ Ожидалась подсказка: " + fieldHint);
    softAssert.assertAll();
  }
}
