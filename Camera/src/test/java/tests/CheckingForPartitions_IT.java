package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.Base;
import data.UserData;
import utils.AssertPartitionsPresent;
import utils.FindText;

public class CheckingForPartitions_IT extends Base {

  @Test (priority = 1)
  public void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM
    );
  }

  @Test (priority = 2)
  void findPartitions() throws InterruptedException {

    SoftAssert softAssert = new SoftAssert();

    Thread.sleep(3000);
    new FindText().findText();

    String[] partitions = {
      "Камеры",
      "Карты",
      "Листы мониторинга",
      "Исторический поиск",
      "Транспортный мониторинг зоны",
      "Транспортный мониторинг линии",
      "ДТП"
    };

    new AssertPartitionsPresent(softAssert)
      .assertPartitionsPresent(partitions);
  }
  /**
   * Нужно пройтись по всей системе,
   * выгрузить список
   *
   * Потом пройтись по списку и сравнить, присутсвуют ли partitions в системе.
   *
   * если да- ок
   * если нет - ошибка\
   *
   *
   * WIP
   */

}


