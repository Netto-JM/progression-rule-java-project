package com.trybe.java.regraprogressao;

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
    }

    scanControl.close();
  }
}
