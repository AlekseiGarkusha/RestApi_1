package setup;

import data.TestDataRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.JsonUtils;

public class BaseSteps{
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected SoftAssert softAssert;
  protected static TestDataRegistration data = JsonUtils.readTestData("TestData.json");
}
