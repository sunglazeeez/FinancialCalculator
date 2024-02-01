package com.sunglazeeez.financialcalculator.mainmenu;

import static java.lang.System.*;

import com.sunglazeeez.financialcalculator.persistence.entity.impl.CompoundInterest;
import com.sunglazeeez.financialcalculator.persistence.entity.impl.LoanPayment;
import com.sunglazeeez.financialcalculator.persistence.entity.impl.SimpleInterest;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The {@code MainMenu} class represents the main menu of a financial calculator application.
 * It provides options for calculating simple interest, compound interest, and loan payments.
 */
public class MainMenu {

  /**
   * Runs the main program loop for the financial calculator application.
   * This method displays the main menu, reads user input, and performs the corresponding calculations.
   *
   * @param scanner The scanner object used to read user input.
   */
  public void runProgram(Scanner scanner) {

    while (true) {
      try {
        // Display main menu options
        out.println("Головне меню:");
        out.println("1. Обрахування простих відсотків");
        out.println("2. Обрахування складних відсотків");
        out.println("3. Розрахування платежу по кредиту");
        out.println("4. Вихід");

        // Read user input
        String userChoice = scanner.nextLine();

        // Perform calculation based on user choice
        switch (userChoice) {
          case "1":

            SimpleInterest simpleInterest = new SimpleInterest();
            simpleInterest.calculateSimpleInterest();
            break;
          case "2":
            CompoundInterest compoundInterest = new CompoundInterest();
            compoundInterest.calculateCompoundInterest();
            break;
          case "3":
            LoanPayment loanPayment = new LoanPayment();
            loanPayment.calculateLoanPayment();
            break;
          case "4":
            // Exit the program
            out.println("Дякуємо за використання додатка. До побачення!");
            return;
          default:
            // Invalid input
            out.println("Невірний вибір. Будь ласка, введіть коректний номер опції ");
        }
      } catch (NoSuchElementException e) {
        // Handle input error
        out.println("Помилка зчитування введення: " + e.getMessage());
        break; // Exit the loop
      }
    }
  }
}
