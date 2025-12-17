/** Тест блокировки и разблокировки пользователя */

package tests.adminOO.blockingUnblockingUser;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;

import static tests.adminOO.editingUser.Locators.*;

public class BlockingUnblockingUser extends Base {

  @Test(priority = 2)
  @Description("Переход к реестру")
  @Severity(SeverityLevel.CRITICAL)
  public void goToUserRegistry() {
    wait.until(ExpectedConditions.elementToBeClickable(ADMINISTRATION_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(USERS_REGISTRY)).click();
    wait.until(ExpectedConditions.elementToBeClickable(EDITING_USER_CARD)).click();
  }

  @Test(priority = 3)
  @Description("Проверка блокировки/разблокировки с учётом текста кнопки")
  @Severity(SeverityLevel.CRITICAL)
  public void toggleBlocking() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();

    final By COMMON_BUTTON_LOCATOR = By.xpath("//a[contains(@href, 'block?id=')]");

    PopUpUtils popUpUtils = new PopUpUtils(driver, wait, softAssert);

    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(COMMON_BUTTON_LOCATOR));
    String text = button.getText();

    if (text.equals("Блокировать")) {
      // Блокирование
      button.click();
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      alert.accept();
      // Проверка popUp
      popUpUtils.assertPopUpContainsText(PopUpMessages.BLOCKING_USER_POP_UP);

      Thread.sleep(3000);

      // Обратное действие - Разблокирование
      WebElement unblockButton = wait.until(ExpectedConditions.elementToBeClickable(COMMON_BUTTON_LOCATOR));
      unblockButton.click();

      Alert unblockAlert = wait.until(ExpectedConditions.alertIsPresent());
      unblockAlert.accept();

      popUpUtils.assertPopUpContainsText(PopUpMessages.UNBLOCKING_USER_POP_UP);
      softAssert.assertAll();

    } else if (text.equals("Разблокировать")) {
      // Разблокировка
      button.click();
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      alert.accept();

      // Проверка popUp
      popUpUtils.assertPopUpContainsText(PopUpMessages.UNBLOCKING_USER_POP_UP);
      softAssert.assertAll();

      Thread.sleep(3000);

      // Обратное действие - Блокирование
      WebElement blockButton = wait.until(ExpectedConditions.elementToBeClickable(COMMON_BUTTON_LOCATOR));
      blockButton.click();

      Alert blockAlert = wait.until(ExpectedConditions.alertIsPresent());
      blockAlert.accept();

      popUpUtils.assertPopUpContainsText(PopUpMessages.BLOCKING_USER_POP_UP);
      softAssert.assertAll();
    }
  }
}
