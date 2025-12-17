/**
 * Авторизация
 * Логин и пароль указываются в документе, где используется эта функция
 */

package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth {
  private final WebDriver driver;
  private final WebDriverWait wait;

  public Auth(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void login(String username, String password) {
    WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-login")));
    loginInput.sendKeys(username);

    WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-password")));
    passwordInput.sendKeys(password);

    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and normalize-space()='Войти']")));
    loginButton.click();

    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-form-login")));
  }
}
