package com.sunglazeeez.financialcalculator.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Custom serializer for converting LocalDate objects into JSON date strings.
 */
public class LocalDateSerializer implements JsonSerializer<LocalDate> {

  /** The date-time formatter used to format LocalDate objects into strings. */
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  /**
   * Serializes a LocalDate object into a JSON element representing a date string.
   *
   * @param localDate The LocalDate object to serialize.
   * @param type The type of the object to serialize (ignored in this implementation).
   * @param jsonSerializationContext The context for serialization (ignored in this implementation).
   * @return A JsonElement representing the serialized LocalDate object.
   */
  @Override
  public JsonElement serialize(LocalDate localDate, Type type,
      JsonSerializationContext jsonSerializationContext) {
    return new JsonPrimitive(formatter.format(localDate));
  }
}
