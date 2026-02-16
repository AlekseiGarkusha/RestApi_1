/**
 * Авторизация
 * Логин и пароль указываются в документе
 */

package setup;

import static com.codeborne.selenide.Selenide.$x;

public class Auth {
  public void fillLoginAndPassword (String username, String password) {
    $x("//input[@name='username']").sendKeys(username);
    $x("//input[@name='password']").sendKeys(password);
    $x("//button[contains(text(), 'Войти')]").click();
  }
}
