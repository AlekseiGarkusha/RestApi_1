//package test;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import setup.Base;;
//
//public class WIP_ChangeStatusTest extends Base {
//
//  public void login() {
//    wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-login"))).sendKeys("AutetestAdminOO777");
//    driver.findElement(By.id("login-form-password")).sendKeys("AutetestAdminOO777!");
//    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-form\"]/div[3]/div[2]/button"))).click();
//  }
//
//  @Test(
//    description = "Переход к созданному заялвению",
//    dependsOnMethods = {"login"})
//  public void goApplication() {
//    WebElement Statements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/a")));
//    Statements.click();
//    // переход в реестр заявлений
//    WebElement RegisterOfApplications =
//      wait.until(ExpectedConditions.elementToBeClickable(
//        By.xpath("/html/body/div/aside[1]/div/nav/ul/li[3]/ul/li[2]")));
//    RegisterOfApplications.click();
//  }
//
//  @Test(
//    description = "Операции внутри заявления",
//    dependsOnMethods = {"goApplication"})
//  public void InsideApplication() {
//    //Переход в последнее заялвениие
//    wait.until(ExpectedConditions.elementToBeClickable(
//      By.xpath("//*[@id=\"w1-container\"]/table/tbody[1]/tr[1]/td[12]/a"))).click();
//    //Переход во вкладку Информация об учреждении СПО и специальностях
//    driver.findElement(By.xpath("//*[@id=\"custom-content-above-tab\"]/li[3]")).click();
//  }
//
//  @Test(
//    description = "Смена статуса специальности",
//    dependsOnMethods = {"InsideApplication"})
//  public void changeStatusSpeciality() {
//    //Клик по кнопке смены специальности (запуск модального окна)
//    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statement-speciality-index-container\"]/table/tbody/tr/td[11]/a[1]"))).click();
//    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modal-speciality-change-status\"]/div/div"))).click();
//
//    //Проверка на статус
//    String status = "Допущен к конкурсу";
//    String pageSource = driver.getPageSource();
//
//    if (pageSource.contains(status)) {
//      wait.until(ExpectedConditions.elementToBeClickable(
//          By.xpath("//*[@id=\"modal-speciality-change-status\"]/div/div/div[1]/button")))
//        .click();
//    } else {
//      //Клик по выпадающему списку "Статус специальности"
//      wait.until(ExpectedConditions.elementToBeClickable(
//          By.id("select2-statementspecialty-status_id-container")))
//        .click();
//      // Т.К. id динамический опускаем стрелочкой вниз + Enter
//      Actions actions = new Actions(driver);
//      actions.sendKeys(Keys.ENTER).build().perform();
//      //Сохранить
//      driver.findElement(
//          By.xpath("//*[@id=\"form-speciality-change-status\"]/div[5]/div/button"))
//        .click();
//    }
//  }
//
//  @Test(
//    description = "Переход на вкладку заявление",
//    dependsOnMethods = {"changeStatusSpeciality"})
//  public void changeTab() {
//
//    driver.findElement(By.xpath("/html/body")).click();
//    wait.until(ExpectedConditions.elementToBeClickable(
//        By.xpath("//*[@id=\"custom-content-above-view-application-tab\"]")))
//      .click();
//  }
//
//  @Test(
//    description = "Поиск и сравнние статуса",
//    dependsOnMethods = {"changeTab"})
//  public void expectedStatus() {
//
//    String expectedStatus = "Заявление принято";
//
//    String pageSource = driver.getPageSource();
//
//    if (pageSource.contains(expectedStatus)) {
//      System.out.println("Статус заявления: " + expectedStatus + " — OK");
//    } else {
//      System.out.println("Статус не найден: " + expectedStatus + " — ERROR");
//    }
//
//    Assert.assertTrue(
//      pageSource.contains(expectedStatus),
//      "Статус '" + expectedStatus + " ' не найден на странице."
//    );
//  }
//}
