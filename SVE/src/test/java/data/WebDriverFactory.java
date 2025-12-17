package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {

  public static WebDriver createDriver(ChromeOptions options) {
    String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

    try {
      if (remoteUrl != null && !remoteUrl.isEmpty()) {
        return new RemoteWebDriver(new URL(remoteUrl), options);
      } else {
        return new ChromeDriver(options);
      }
    } catch (Exception e) {
      throw new RuntimeException("Ошибка создания WebDriver", e);
    }
  }
}

