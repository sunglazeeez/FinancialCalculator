package com.sunglazeeez.financialcalculator.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
/**
 * Represents an abstract entity in the financial calculator application.
 * This class serves as a base class for other entities and provides common functionality.
 */
public abstract class Entity {
  /** The unique identifier for the entity. */
  protected final UUID id;
  /** The list of errors associated with the entity. */
  protected List<String> errors;
  /**
   * Constructs a new Entity object with the specified identifier.
   *
   * @param id The unique identifier for the entity.
   */
  protected Entity(UUID id) {
    errors = new ArrayList<>();
    this.id = id;
  }
  /**
   * Checks if this entity object is equal to another object.
   *
   * @param o The object to compare with.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(id, entity.id);
  }
  /**
   * Returns the hash code of the entity object.
   *
   * @return The hash code of the entity object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}