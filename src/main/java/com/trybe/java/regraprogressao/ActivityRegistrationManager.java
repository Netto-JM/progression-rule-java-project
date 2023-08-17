package com.trybe.java.regraprogressao;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The ActivityRegistrationManager class is responsible for managing the registration
 * of activities including their names, weights, and grades from the user.
 * <p>
 * It provides a method {@link #collectActivities()} that prompts the user to enter the
 * quantity of activities to be registered and then collects information for each activity,
 * including its name, weight, and grade.
 * </p>
 * <p>
 * This class utilizes the {@link java.util.Scanner} class for user input and handles
 * exceptions such as {@link java.util.InputMismatchException} and
 * {@link java.util.NoSuchElementException} that can occur during input operations.
 * </p>
 *
 * @since 1.0
 */
public class ActivityRegistrationManager {

  /**
   * Informs the results based on the provided total grade and total weigh.
   *
   * @param totalGrade The total grade obtained.
   * @param totalWeigh The total weigh of activities.
   */
  public static void informResults(float totalGrade, float totalWeigh) {
    DecimalFormat df = new DecimalFormat("#.#");
    float finalGrade = totalGrade / totalWeigh;
    finalGrade = Float.parseFloat(df.format(finalGrade).replace(',', '.'));
    String congratsMessage = "Parabéns! Você alcançou " + finalGrade + "%! "
        + "E temos o prazer de informar que você obteve aprovação!";
    String sorryMessage = "Lamentamos informar que, com base na sua pontuação "
        + "alcançada neste período, " + finalGrade + "%, você não atingiu a "
        + "pontuação mínima necessária para sua aprovação.";

    if (finalGrade >= 85) {
      System.out.println(congratsMessage);
    } else {
      System.out.println(sorryMessage);
    }
  }

  /**
   * Collects information about a specified number of activities from the user.
   * Activities include their names, weights, and grades.
   * <p>
   * This method prompts the user to enter the quantity of activities to be registered,
   * then iterates through each activity, collecting its name, weight, and grade.
   * </p>
   *
   * @throws java.util.InputMismatchException if the user enters invalid input for integers.
   * @throws java.util.NoSuchElementException if the user input is exhausted unexpectedly.
   */
  public static void collectActivities() {
    Scanner scanControl = new Scanner(System.in);

    String activityName;
    int activityWeigh;
    String activityWeighScan;
    int activityGrade;
    String activityGradeScan;
    float totalGrade = 0.00f;
    float totalWeigh = 0.00f;


    System.out.println("Digite a quantidade de atividades para cadastrar:");
    String activityQuantityScan = scanControl.nextLine();
    int activityQuantity = Integer.parseInt(activityQuantityScan);

    for (int i = 0; i < activityQuantity; i++) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ":");
      activityName = scanControl.nextLine();
      System.out.println("Digite o peso da atividade " + (i + 1) + ":");
      activityWeighScan = scanControl.nextLine();
      activityWeigh = Integer.parseInt(activityWeighScan);
      System.out.println("Digite a nota obtida para " + activityName + ":");
      activityGradeScan = scanControl.nextLine();
      activityGrade = Integer.parseInt(activityGradeScan);
      totalGrade += (float) (activityGrade * activityWeigh);
      totalWeigh += (float) activityWeigh;
    }

    informResults(totalGrade, totalWeigh);

    scanControl.close();
  }
}
