package setup;

import data.GeneratedTestData;
import data.TestDataRegistration;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.ScreenshotUtil;

import java.time.Duration;

public class BaseSuperAdmin {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected TestDataRegistration data;

  @BeforeClass
  public void beforeClass() {
    Setup setup = new Setup();
    driver = setup.getDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    setup.openPage("https://beta.rkspo.ru/user/login");

    data = JsonUtils.readTestData("TestData.json");
    GeneratedTestData.generateGrades();
  }

  @AfterMethod
  public void takeScreenshotOnFailure(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      String fileName = result.getName() + "_" + System.currentTimeMillis();
      ScreenshotUtil.takeScreenshot(driver, fileName);
    }
  }

  @AfterClass
  public void tearDown() {
    Setup.closeBrowser();
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }

  @Test(priority = 1)
  @Description("Авторизация")
  @Severity(SeverityLevel.CRITICAL)
  public void auth() {
    Auth auth = new Auth(driver, wait);
    auth.login(
      "admin",
      "SKU46adm");
  }
}
