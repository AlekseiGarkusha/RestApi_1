/**
 * Позитивный тест на логин и разлогин пользователя Администратор.
 */

package tests.administrator;

import com.codeborne.selenide.SelenideElement;
import data.UserData;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Auth;
import setup.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static data.ErrorMessage.adminNotLogIn;
import static data.ErrorMessage.adminNotLogOut;

public class LoginLogout extends TestBase {

  @Test(priority = 1)
  @Description("Авторизация и проверка")
  public void login() throws InterruptedException {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN_ADMINISTRATOR_ITM,
      UserData.PASSWORD_ADMINISTRATOR_ITM
    );

    Thread.sleep(1000);
    SelenideElement adminPanel = $(byText("admin-mintrans"));
    Assert.assertTrue(adminPanel.exists(), adminNotLogIn);
  }

  @Test(priority = 2)
  @Description("Выход из роли")
  public void logout() {
    $(".nav-item-wrap").click();
    SelenideElement enterToSystem = $(byText("Вход в систему"));
    Assert.assertTrue(enterToSystem.exists(), adminNotLogOut);
  }
}
