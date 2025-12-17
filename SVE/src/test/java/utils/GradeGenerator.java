/** Генерация рандомных оценок при регистрации в шаге 3 */

package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GradeGenerator {

  public static @NotNull String generateFives() {
    return String.valueOf(new Random().nextInt(5) + 1);
  }

  public static @NotNull String generateFours() {
    return String.valueOf(new Random().nextInt(5) + 1);
  }

  public static @NotNull String generateThrees() {
    return String.valueOf(new Random().nextInt(5) + 1);
  }
}
