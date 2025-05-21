package com.canvas.validation;

import com.canvas.model.Canvas;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public abstract class BaseValidator implements Validator {
  protected List<String> parameters;
  protected Canvas canvas;

  public boolean isValidPosition(int x, int y) {
    if (canvas != null) {
      return x >= 1 && y >= 1 && x <= canvas.getWidth() && y <= canvas.getHeight();
    }
    return false;
  }
}
