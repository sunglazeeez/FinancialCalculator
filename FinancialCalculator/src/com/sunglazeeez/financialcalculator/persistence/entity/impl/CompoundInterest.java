package com.sunglazeeez.financialcalculator.persistence.entity.impl;

import static java.lang.System.*;
import java.util.Scanner;

/**
 * The {@code CompoundInterest} class represents a utility for calculating compound interest.
 * It provides a static method {@code calculateCompoundInterest} to perform compound interest calculations.
 */
public class CompoundInterest {

  /**
   * Calculates compound interest based on user input.
   * This method prompts the user to enter the principal amount, annual interest rate, duration in years,
   * and the number of times interest is compounded per year, and then computes the compound interest and total amount.
   */
  public static void calculateCompoundInterest() {
    Scanner scanner = new Scanner(in);

    // Prompt user for principal amount
    out.println("Введіть суму кредиту:");
    double principal = scanner.nextDouble();

    // Prompt user for annual interest rate
    out.println("Введіть річний відсоток:");
    double annualInterestRate = scanner.nextDouble();

    // Prompt user for duration in years
    out.println("Введіть тривалість у роках:");
    int years = scanner.nextInt();

    // Prompt user for the number of times interest is compounded per year
    out.println("Введіть кількість разів на рік, коли проценти нараховуються:");
    int compoundsPerYear = scanner.nextInt();

    // Calculate compound interest
    double compoundInterest = principal * Math.pow(1 + (annualInterestRate / compoundsPerYear), compoundsPerYear * years) - principal;

    // Display compound interest and total amount
    out.println("Складний відсоток: " + compoundInterest);
    out.println("Загальна сума: " + (principal + compoundInterest));
  }
}
