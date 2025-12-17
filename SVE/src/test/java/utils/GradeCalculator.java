/** Вычисление среднего балла аттестата с выполненными условиями*/

package utils;

import data.GeneratedTestData;

public class GradeCalculator {

  public static String GradeGenerator() {

    int fives = Integer.parseInt(GeneratedTestData.gradeFives);
    int fours = Integer.parseInt(GeneratedTestData.gradeFours);
    int threes = Integer.parseInt(GeneratedTestData.gradeThrees);

    int totalGrades = fives + fours + threes;

    if (totalGrades == 0) {
      return "0";
    }

    int totalPoints = fives * 5 + fours * 4 + threes * 3;
    double rawAverage = (double) totalPoints / totalGrades;
    double rounded = Math.round(rawAverage * 1000.0) / 1000.0;

    if (rounded == (long) rounded) {
      return String.valueOf((long) rounded);
    } else {
      return String.valueOf(rounded);
    }
  }
}



