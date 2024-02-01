package com.sunglazeeez.financialcalculator.util;

import static java.lang.System.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sunglazeeez.financialcalculator.persistence.entity.impl.User;
import com.sunglazeeez.financialcalculator.persistence.exception.EntityArgumentException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Utility class for user registration and file operations related to user data.
 */
public class Registration {

  /**
   * Reads user data from a file and returns a list of users.
   *
   * @param filePath The path to the file containing user data.
   * @return A list of User objects read from the file.
   */
  public static List<User> readUsersFromFile(String filePath) {
    List<User> userList = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      // Creates a Gson instance with LocalDate deserialization capability
      Gson gson = new GsonBuilder()
          .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
          .create();

      // Defines the type for deserializing the list of users
      Type userListType = new TypeToken<List<User>>() {}.getType();

      // Reads the file content and deserializes it into a list of users
      userList = gson.fromJson(reader, userListType);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return userList;
  }

  /**
   * Writes a list of users to a file.
   *
   * @param users    The list of User objects to write to the file.
   * @param filePath The path to the file where user data will be written.
   */
  private static void writeUsersToFile(List<User> users, String filePath) {
    try (FileWriter writer = new FileWriter(filePath)) {
      // Creates a Gson instance with pretty printing
      Gson gson = new GsonBuilder()
          .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
          .setPrettyPrinting().create();

      // Converts the list of users to JSON and writes it to the file
      gson.toJson(users, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Performs user registration based on input from the user.
   *
   * @param filePath The path to the file containing user data.
   */
  public void registration(String filePath) {
    try (Scanner scanner = new Scanner(in)) {
      List<User> users = readUsersFromFile(filePath);

      // User input
      UUID userId = UUID.randomUUID();
      out.println("Реєстрацiя облiкового запису:");
      out.print("Напишiть username (name.name): ");
      String username = scanner.nextLine();
      out.print("Напишiть password (не меньше 8 символiв): ");
      String password = scanner.nextLine();
      out.print("Напишiть email (name@gmail.com): ");
      String email = scanner.nextLine();
      out.print("Напишiть birthday (YYYY-MM-DD): ");
      LocalDate birthday = LocalDate.parse(scanner.nextLine());

      if (userAlreadyExists(users, email, username)) {
        out.println("Помилка: Користувач з такою ж адресою електронної пошти або iм'ям користувача вже iснує ❗");
        return;
      }

      // Creates a new user object and adds it to the list
      User user = new User(userId, password, email, birthday, username);
      users.add(user);

      // Overwrites the JSON file with the updated list of users
      writeUsersToFile(users, filePath);

      out.println("Реєстрацiя успiшна ");

      // Automatically calls the authentication method
      Authorisation.authenticate(filePath);

    } catch (EntityArgumentException e) {
      // Handles errors that occur during user creation
      for (String error : e.getErrors()) {
        out.println("Помилка:" + error);
      }
    } catch (DateTimeParseException e) {
      // Handles errors if the date is entered incorrectly
      out.println("Помилка: Неправильний формат дати. Будь ласка, введiть дату у форматi YYYY-MM-DD ");
    }
  }

  /**
   * Checks if a user with the given email or username already exists in the list of users.
   *
   * @param users    The list of users to check against.
   * @param email    The email to check.
   * @param username The username to check.
   * @return {@code true} if a user with the given email or username already exists, {@code false} otherwise.
   */
  private boolean userAlreadyExists(List<User> users, String email, String username) {
    for (User user : users) {
      if (user.getEmail().equals(email) || user.getUsername().equals(username)) {
        return true;
      }
    }
    return false;
  }
}
