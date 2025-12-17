package data;

import utils.random.GenerateRandomNumber;
import utils.random.GenerateRandomSeries;

public class GeneratedTestData {
  public static final String series = GenerateRandomSeries.generateRandomSeries();
  public static final String number = GenerateRandomNumber.generateRandomNumber();

  public static String gradeFives;
  public static String gradeFours ;
  public static String gradeThrees ;

  public static void generateGrades(){
    gradeFives = utils.GradeGenerator.generateFives();
    gradeFours = utils.GradeGenerator.generateFours();
    gradeThrees = utils.GradeGenerator.generateThrees();
  }
}
