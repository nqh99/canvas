package com.canvas.validation;

import com.canvas.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanvasValidator extends BaseValidator {

  @Override
  public List<String> validate() {
    List<String> result = new ArrayList<>();
    if (parameters.isEmpty()) {
      result.add(Messages.PARAMETERS_EXPECTED);
    } else if (parameters.size() > 2) {
      result.add(Messages.TOO_MANY_PARAMETERS);
    } else if (parameters.size() < 2) {
      result.add(Messages.MISSING_PARAMETERS);
    } else {
      try {
        if (!Util.isPositiveList(Arrays.asList(parameters.get(0), parameters.get(1)))) {
          result.add(Messages.CANVAS_SIZE_POSITIVE);
        }
      } catch (NumberFormatException e) {
        result.add(String.format(Messages.NUMBER_PARAMETERS_INVALID, e.getMessage()));
      }
    }
    return result;
  }
}
