package com.sunglazeeez.financialcalculator.persistence.entity.impl;

import static java.lang.System.*;
import java.util.Scanner;

/**
 * The {@code SimpleInterest} class represents a utility for calculating simple interest.
 * It provides a static method {@code calculateSimpleInterest} to compute the simple interest and total amount for a loan.
 */
public class SimpleInterest {

  /**
   * Calculates the simple interest and total amount for a loan based on user input.
   * This method prompts the user to enter the principal amount, annual interest rate, and duration in years,
   * then computes the simple interest and total amount using the simple interest formula.
   */
  public static void calculateSimpleInterest() {
    Scanner scanner = new Scanner(in);

    // Prompt user for input data
    out.print("Введiть суму кредиту: ");
    double principal = scanner.nextDouble();

    out.print("Введiть рiчний вiдсоток (%): ");
    double annualInterestRate = scanner.nextDouble();

    out.print("Введiть тривалiсть у роках: ");
    int years = scanner.nextInt();

    // Calculate simple interest
    double simpleInterest = (principal * annualInterestRate * years) / 100;

    // Calculate total amount (principal + simple interest)
    double totalAmount = principal + simpleInterest;

    // Display results
    out.println("Простий вiдсоток: " + simpleInterest);
    out.println("Загальна сума: " + totalAmount);
  }
}
