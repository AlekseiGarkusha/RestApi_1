package tests._base;

import data.UserData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;
import tests._base.methods.Role;
import utils.AssertPartitionsPresent;

public class CheckingForPartitions_IT extends TestBase {

  @Test(priority = 1)
  public void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN_ANALITIK_ITM,
      UserData.PASSWORD_ANALITIK_ITM
    );
  }

  /**
   * WIP
   *
   */

  @Test(priority = 2)
  void findPartitions() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Thread.sleep(3000);

    Role roleObj = new Role();
    String[] partitions = roleObj.choiceRole("admin");

    new AssertPartitionsPresent(softAssert).assertPartitionsPresent(partitions);
  }
}
