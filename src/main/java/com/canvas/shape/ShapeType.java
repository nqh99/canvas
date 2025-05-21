package com.canvas.shape;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ShapeType {
  CANVAS("C"),
  POINT("P"),
  LINE("L"),
  RECTANGLE("R"),
  BUCKET("B");

  private final String value;

  public static ShapeType fromValue(String value) {
    return Arrays.stream(ShapeType.values())
        .filter(shapeType -> shapeType.getValue().equals(value))
        .findAny()
        .orElse(null);
  }
}
