package com.sunglazeeez.financialcalculator.persistence.exception;

import java.util.List;

/**
 * Custom exception class representing an exception that occurs when an entity's arguments are invalid.
 * Extends IllegalArgumentException.
 */
public class EntityArgumentException extends IllegalArgumentException {

  private final List<String> errors;

  /**
   * Constructs an EntityArgumentException with a list of error messages.
   * @param errors The list of error messages.
   */
  public EntityArgumentException(List<String> errors) {
    this.errors = errors;
  }

  /**
   * Retrieves the list of error messages associated with the exception.
   * @return The list of error messages.
   */
  public List<String> getErrors() {
    return errors;
  }
}
