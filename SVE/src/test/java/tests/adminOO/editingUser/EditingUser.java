/** Тест редактирования карточки пользователя
 * Проверки:
 * 1 - Изменения полей,
 * 2 - Обязательности полей,
 * 3 - Всплывающего popUp,
 * 4 - Соответствие вводимых значений и сохранённых
 */

package tests.adminOO.editingUser;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;

import static tests.adminOO.editingUser.Locators.*;

public class EditingUser extends Base {

  @Test(priority = 2)
  @Description("Переход к реестру")
  @Severity(SeverityLevel.CRITICAL)
  public void goToUserRegistry() {
    wait.until(ExpectedConditions.elementToBeClickable(ADMINISTRATION_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(USERS_REGISTRY)).click();
    wait.until(ExpectedConditions.elementToBeClickable(EDITING_USER_CARD)).click();
  }

  @Test(priority = 3)
  @Description("Очистка полей")
  @Severity(SeverityLevel.CRITICAL)
  public void clearFields()  {
    wait.until(ExpectedConditions.elementToBeClickable(USER_LOGIN)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_EMAIL)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_FULL_NAME)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_POSITION)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_PHONE)).clear();
  }

  @Test(priority = 4)
  @Description("Проверка обязательности полей")
  @Severity(SeverityLevel.CRITICAL)
  public void checkRequiredFields() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_REFRESH)).click();

    Thread.sleep(2000);

    String[] fieldHints = {
      "Необходимо заполнить «Логин».",
      "Необходимо заполнить «Email».",
      "Необходимо заполнить «ФИО».",
      "Необходимо заполнить «Должность».",
      "Необходимо заполнить «Телефон».",
    };

    String pageSource = driver.getPageSource();

    for (String hint : fieldHints) {
      Assert.assertTrue(
        pageSource.contains(hint),
        "Ожидалась подсказка: " + hint
      );
    }
  }

  @Test(priority = 5)
  @Description("Очистка полей -2 (После починки бага - УДАЛИТЬ)")
  @Severity(SeverityLevel.CRITICAL)
  public void clearFields_2() {
    wait.until(ExpectedConditions.elementToBeClickable(USER_LOGIN)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_EMAIL)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_FULL_NAME)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_POSITION)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(USER_PHONE)).clear();
  }

  @Test(priority = 6)
  @Description("Изменение данных")
  @Severity(SeverityLevel.CRITICAL)
  public void changingData() {
    wait.until(ExpectedConditions.elementToBeClickable(USER_LOGIN)).sendKeys(data.editingUser.login);
    wait.until(ExpectedConditions.elementToBeClickable(USER_EMAIL)).sendKeys(data.editingUser.email);
    wait.until(ExpectedConditions.elementToBeClickable(USER_FULL_NAME)).sendKeys(data.editingUser.fullName);
    wait.until(ExpectedConditions.elementToBeClickable(USER_POSITION)).sendKeys(data.editingUser.position);
    wait.until(ExpectedConditions.elementToBeClickable(USER_PHONE)).sendKeys(data.editingUser.phone);
    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_REFRESH)).click();
  }

  @Test(priority = 7)
  @Description("Проверка на всплывающий popUp")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText(PopUpMessages.EDITING_USER);
    softAssert.assertAll();
  }

  @Test(priority = 8)
  @Description("Проверка на соответствие полей")
  @Severity(SeverityLevel.CRITICAL)
  public void checkComparisonFields() {
    WebElement userLogin = wait.until(ExpectedConditions.elementToBeClickable(USER_LOGIN));
    Assert.assertEquals(userLogin.getAttribute("value"), data.editingUser.login, "Логин");

    WebElement userEmail = wait.until(ExpectedConditions.elementToBeClickable(USER_EMAIL));
    Assert.assertEquals(userEmail.getAttribute("value"), data.editingUser.email, "Email");

    WebElement userFullName = wait.until(ExpectedConditions.elementToBeClickable(USER_FULL_NAME));
    Assert.assertEquals(userFullName.getAttribute("value"),data.editingUser.fullName, "ФИО" );

    WebElement userPosition = wait.until(ExpectedConditions.elementToBeClickable(USER_POSITION));
    Assert.assertEquals(userPosition.getAttribute("value"), data.editingUser.position,"Должность");

    WebElement userPhone = wait.until(ExpectedConditions.elementToBeClickable(USER_PHONE));
    Assert.assertEquals(userPhone.getAttribute("value"), "+7 (555)-555-55-55", "Телефон");
  }
}
