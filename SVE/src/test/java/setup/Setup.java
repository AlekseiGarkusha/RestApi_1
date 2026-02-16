/**
 * Класс запуска chrome драйвера
 * Указание директории для Allure
 */

package setup;

import data.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Setup {

  private static WebDriver driver;
  private final WebDriverWait wait;

  static {
    WebDriverManager.chromedriver().setup();
    System.setProperty("allure.results.directory", "target/allure-results");
  }

  public Setup() {
    if (driver == null) {
      ChromeOptions options = new ChromeOptions();
      options.setCapability("browserName", "chrome");
//      options.addArguments("--headless=new");                            /// отображение браузера или скрытие
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--disable-gpu");
      options.addArguments("--window-size=1920,1080");

      String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

      try {
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
          System.out.println("Подключение к удалённому Selenium: " + remoteUrl);
          driver = WebDriverFactory.createDriver(options);
        } else {
          System.out.println("Локальный запуск ChromeDriver");
          WebDriverManager.chromedriver().setup();
          driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Ошибка при создании WebDriver: " + e.getMessage(), e);
      }
    } else {
      System.out.println("Используется уже существующий драйвер");
    }

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriverWait getWait() {
    return wait;
  }

  public void openPage(String url) {
    driver.get(url);
  }

  public static void closeBrowser() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
