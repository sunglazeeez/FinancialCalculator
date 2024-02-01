package com.sunglazeeez.financialcalculator.persistence.entity.impl;

import static java.lang.System.*;
import java.util.Scanner;

/**
 * The {@code LoanPayment} class represents a utility for calculating loan payments.
 * It provides a static method {@code calculateLoanPayment} to compute the monthly payment for a loan.
 */
public class LoanPayment {

  /**
   * Calculates the monthly payment for a loan based on user input.
   * This method prompts the user to enter the principal amount, annual interest rate, and duration in years,
   * then computes the monthly payment using the loan formula.
   */
  public static void calculateLoanPayment() {
    Scanner scanner = new Scanner(in);

    // Prompt user for principal amount
    out.println("Введiть суму кредиту:");
    double principal = scanner.nextDouble();

    // Prompt user for annual interest rate
    out.println("Введiть рiчний вiдсоток:");
    double annualInterestRate = scanner.nextDouble();

    // Prompt user for duration in years
    out.println("Введiть тривалiсть у роках:");
    int years = scanner.nextInt();

    // Convert annual interest rate to monthly
    double monthlyInterestRate = annualInterestRate / 12 / 100;

    // Calculate number of payments
    int numberOfPayments = years * 12;

    // Calculate monthly payment for the loan
    double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

    // Display the monthly payment
    out.println("Щомiсячний платiж: " + monthlyPayment);
  }
}
