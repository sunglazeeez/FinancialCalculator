package com.sunglazeeez.financialcalculator.persistence.entity.impl;

import com.sunglazeeez.financialcalculator.persistence.entity.Entity;
import com.sunglazeeez.financialcalculator.persistence.entity.ErrorTemplates;
import com.sunglazeeez.financialcalculator.persistence.exception.EntityArgumentException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;
/**
 * Represents a user entity in the financial calculator application.
 * This class extends the {@link Entity} class.
 */
public class User extends Entity {
  /** The user's password. */
  private final String password;

  /** The user's date of birth. */
  private final LocalDate birthday;

  /** The user's email address. */
  private String email;

  /** The user's username. */
  private String username;

  /**
   * Constructs a new User object with the specified parameters.
   *
   * @param id       The unique identifier for the user.
   * @param password The password for the user's account.
   * @param email    The email address of the user.
   * @param birthday The date of birth of the user.
   * @param username The username chosen by the user.
   * @throws EntityArgumentException if there are validation errors with the provided parameters.
   */


  public User(UUID id, String password, String email, LocalDate birthday, String username) {
    super(id);
    this.password = validatedPassword(password);
    setEmail(email);
    this.birthday = validatedBirthday(birthday);
    setUsername(username);
  }
  /**
   * Gets the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return username;
  }
  /**
   * Gets the email address of the user.
   *
   * @return The email address of the user.
   */
  public String getEmail() {
    return email;
  }
  /**
   * Sets the email address of the user.
   *
   * @param email The email address to be set for the user.
   * @throws EntityArgumentException if the provided email address is invalid or blank.
   */
  public void setEmail(String email) {
    final String templateName = "email";

    /**
     * Validates the birthday of the user.
     *
     * @param birthday The birthday to be validated.
     * @return The validated birthday of the user.
     * @throws EntityArgumentException if the provided birthday is invalid or blank.
     */
    if (email.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    var pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
    if (!pattern.matcher(email).matches()) {
      errors.add(ErrorTemplates.INVALID_EMAIL.getTemplate().formatted(templateName, 24));
    }

    if (!this.errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }

    this.email = email;
  }

  public LocalDate validatedBirthday(LocalDate birthday) {
    /**
     * Sets the username for the user.
     *
     * @param username The username to be set for the user.
     * @throws EntityArgumentException if the provided username is invalid or blank.
     */
    final String templateName = "birthday";

    if (password.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }

    var pattern = Pattern.compile("^\\d{4},\\d{2},\\d{2}$");
    if (pattern.matcher(password).matches()) {
      errors.add(ErrorTemplates.PASSWORD.getTemplate().formatted(templateName, 24));
    }

    if (!this.errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }

    return birthday;
  }

  public void setUsername(String username) {
    final String templateName = "username";
    /**
     * Validates the password for the user.
     *
     * @param password The password to be validated.
     * @return The validated password for the user.
     * @throws EntityArgumentException if the provided password is invalid or blank.
     */
    if (username.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    if (username.length() < 4) {
      errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 4));
    }
    if (username.length() > 24) {
      errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 24));
    }
    var pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
    if (pattern.matcher(username).matches()) {
      errors.add(ErrorTemplates.ONLY_LATIN.getTemplate().formatted(templateName, 24));
    }

    if (!this.errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }

    this.username = username;
  }

  private String validatedPassword(String password) {
    final String templateName = "password";
    /**
     * Checks if this user object is equal to another object.
     *
     * @param o The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */

    if (password.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    if (password.length() < 8) {
      errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 8));
    }
    if (password.length() > 32) {
      errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 32));
    }
    var pattern = Pattern.compile("\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d).+$\"");
    if (pattern.matcher(password).matches()) {
      errors.add(ErrorTemplates.PASSWORD.getTemplate().formatted(templateName, 24));
    }

    if (!this.errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }

    return password;
  }

  @Override
  public boolean equals(Object o) {
    /**
     * Returns a string representation of the user object.
     *
     * @return A string representation of the user object.
     */
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(email, user.email);
  }

  @Override
  public String toString() {
    /**
     * Returns the hash code of the user object.
     *
     * @return The hash code of the user object.
     */
    return "User{" +
        "password='" + password + '\'' +
        ", birthday=" + birthday +
        ", email='" + email + '\'' +
        ", username='" + username + '\'' +
        ", id=" + id +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }
}