package com.sunglazeeez.financialcalculator;

import static java.lang.System.*;

import com.sunglazeeez.financialcalculator.util.Authorisation;
import com.sunglazeeez.financialcalculator.util.Registration;
import com.sunglazeeez.financialcalculator.mainmenu.MainMenu;
import java.util.Scanner;

/**
 * The main class of the financial calculator application.
 */
public class Main {

  /** The path to the directory containing data files. */

  /**
   * The main entry point of the application.
   *
   * @param args The command line arguments (not used).
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(in);
    boolean loop = true;

    while (loop) {
      out.println("Вiтаємо вас у фiнансовому калькуляторi");
      out.println("1. Вхiд");
      out.println("2. Реєстрацiя");
      out.println("3. Вихiд");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          if (Authorisation.authenticate("Data/Users.json")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.runProgram(scanner);
          }
          loop = false;
          break;
        case 2:
          Registration registration = new Registration();
          registration.registration("Data/Users.json");
          loop = false;
          break;
        case 3:
          out.println("Дякуємо за використання фiнансового калькулятора. До побачення!");
          loop = false;
          break;
        default:
          out.println("Невiрний вибiр. Будь ласка, виберiть знову");
      }
    }
  }
}
