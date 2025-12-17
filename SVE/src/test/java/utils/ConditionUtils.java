/** хэлпер для упаковки всех выбранных специальных условий, в один массив
 * Используетс в RegistrationComparisonFields, для сравнения специальных условий
 */


package utils;

import data.SpecialConditions;

public class ConditionUtils {
  public static String[] toArray(SpecialConditions cond) {
    if (cond == null) {
      throw new IllegalArgumentException("SpecialConditions не должен быть null");
    }

    return new String[]{
      cond.condition_1,
      cond.condition_2,
      cond.condition_3,
      cond.condition_4,
      cond.condition_5,
      cond.condition_6
    };
  }
}




