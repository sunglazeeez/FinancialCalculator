package com.sunglazeeez.financialcalculator.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Custom deserializer for converting JSON date strings into LocalDate objects.
 */
public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

  /**
   * Deserializes a JSON element representing a date string into a LocalDate object.
   *
   * @param json    The JSON element representing the date string.
   * @param typeOfT The type of the object to deserialize to (ignored in this implementation).
   * @param context The context for deserialization (ignored in this implementation).
   * @return A LocalDate object parsed from the JSON element.
   * @throws JsonParseException If parsing of the JSON element fails.
   */
  @Override
  public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
  }
}
