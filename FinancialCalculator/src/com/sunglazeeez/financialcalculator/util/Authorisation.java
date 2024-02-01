package com.sunglazeeez.financialcalculator.util;

import static java.lang.System.*;

import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class for user authentication.
 */
public class Authorisation {

  /**
   * Authenticates the user by checking the provided username and password against stored credentials.
   * Reads JSON data from the specified file and prompts the user for credentials.
   *
   * @param fileName The name of the file containing user credentials in JSON format.
   * @return {@code true} if authentication is successful, {@code false} otherwise.
   */
  public static boolean authenticate(String fileName) {
    Scanner scanner = new Scanner(in);

    try {
      // Reads JSON from the file
      JsonArray jsonArray = new Gson().fromJson(new FileReader(fileName), JsonArray.class);
      out.println("Вхід в обліковий запис");
      out.print("Введіть username: ");
      String enteredUsername = scanner.nextLine();

      // Checks for "exit" option
      if (enteredUsername.equalsIgnoreCase("вихід")) {
        out.println("Вихід з програми...");
        return false; // Exits the program
      }

      out.print("Введіть password: ");
      String enteredPassword = scanner.nextLine();

      // Checks for "exit" option
      if (enteredPassword.equalsIgnoreCase("вихід")) {
        out.println("Вихід з програми...");
        return false; // Exits the program
      }

      // Iterates through each object in the JSON array
      for (JsonElement jsonElement : jsonArray) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Retrieves information from JSON
        String storedUsername = jsonObject.get("username").getAsString();
        String storedPassword = jsonObject.get("password").getAsString();

        // Checks entered data
        if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
          out.println("Вхід успішний");
          return true; // Returns true indicating successful authentication
        }
      }
      // If this code is reached, authentication failed
      out.println("Помилка входу. Неправильне ім'я користувача або пароль!");
    } catch (JsonParseException | IOException e) {
      e.printStackTrace();
    }

    return false; // Returns false indicating unsuccessful authentication
  }
}
