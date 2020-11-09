package com.eljaiek.machinery.configuration.core;

import java.util.Map;
import java.util.function.Consumer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class MutablePropertyFactory implements PropertyFactory {

  private final Consumer<Property> save;
  private final Consumer<String> deleteByKey;

  @Override
  public Property create(@NonNull Map.Entry<String, String> entry) {
    return create(entry.getKey(), entry.getValue());
  }

  @Override
  public Property create(String key, String value) {

    if (key == null || key.isBlank()) {
      throw new IllegalArgumentException("key cannot be null or blank.");
    }

    return new MutableProperty(key, value, save, deleteByKey);
  }
}
