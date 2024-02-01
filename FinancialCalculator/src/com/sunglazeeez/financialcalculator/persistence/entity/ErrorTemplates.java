package com.sunglazeeez.financialcalculator.persistence.entity;

/**
 * Enum representing different error templates for field validation messages in the application.
 */
public enum ErrorTemplates {
  /**
   * Error message template for indicating that a field is required.
   * Format: "Field %s is required!"
   */
  REQUIRED("Поле %s є обов'язковим до заповнення!"),

  /**
   * Error message template for indicating that a field must have a minimum length.
   * Format: "Field %s cannot be less than %d characters!"
   */
  MIN_LENGTH("Поле %s не може бути меншим за %d симв!"),

  /**
   * Error message template for indicating that a field must have a maximum length.
   * Format: "Field %s cannot be greater than %d characters!"
   */
  MAX_LENGTH("Поле %s не може бути бiльшим за %d симв!"),

  /**
   * Error message template for indicating that a field can only contain Latin characters and a mandatory dot.
   * Format: "Field %s should contain only Latin characters and a mandatory dot!"
   */
  ONLY_LATIN("Поле %s лише латинськi символи i обов'язкова крапка!"),

  /**
   * Error message template for indicating that a field contains an invalid email format.
   * Format: "Field %s should contain only Latin characters and '@' symbol!"
   */
  INVALID_EMAIL("Поле %s лише латинськi символи та символ @!"),

  /**
   * Error message template for indicating password requirements.
   * Format: "Field %s should contain Latin characters, at least one uppercase letter, one lowercase letter, and one digit!"
   */
  PASSWORD("Поле %s латинськi миволи, хочаб одна буква з великої, одна з малої та хочаб одна цифра!");

  private final String template;

  /**
   * Constructs an ErrorTemplates enum with the specified error message template.
   * @param template The error message template.
   */
  ErrorTemplates(String template) {
    this.template = template;
  }

  /**
   * Retrieves the error message template associated with the enum constant.
   * @return The error message template.
   */
  public String getTemplate() {
    return template;
  }
}
