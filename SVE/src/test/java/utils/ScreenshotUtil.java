/** cохранение screenshots ошибок */

package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {
  public static void takeScreenshot(WebDriver driver, String fileName) {
    try {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File srcFile = ts.getScreenshotAs(OutputType.FILE);
      File destFile = new File("screenshots/" + fileName + ".png");
      destFile.getParentFile().mkdirs();
      Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
      System.out.println("Скриншот сохранён: " + destFile.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}