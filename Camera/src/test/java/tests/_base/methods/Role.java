package tests._base.methods;

import org.testng.Assert;

import java.util.Arrays;

public class Role {

  public String[] choiceRole(String role) {
    String[] partitions = new String[0];

    if (role.equals("analitic") || role.equals("operator")) {
      partitions = new String[]{
        "Камеры",
        "Карты",
        "Листы мониторинга",
        "Исторический поиск",
        "Транспортный мониторинг зоны",
        "Транспортный мониторинг линии",
        "ДТП"
      };
    } else if (role.equals("admin")) {
      partitions = new String[]{
        "Оператор",
        "Аналитик"

      };
      System.out.println(Arrays.toString(partitions));

    } else {
      Assert.fail("Тест отображения элементов навигации - провален");
    }
    System.out.println(Arrays.toString(partitions));
    return partitions;

  }
}
