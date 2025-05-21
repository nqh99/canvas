package com.canvas.validation;

import com.canvas.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangleValidator extends BaseValidator {

  @Override
  public List<String> validate() {
    List<String> result = new ArrayList<>();
    if (parameters.isEmpty()) {
      result.add(Messages.PARAMETERS_EXPECTED);
    } else if (parameters.size() > 5) {
      result.add(Messages.TOO_MANY_PARAMETERS);
    } else if (parameters.size() < 5) {
      result.add(Messages.MISSING_PARAMETERS);
    } else {
      try {
        if (!Util.isPositiveList(
            Arrays.asList(
                parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3)))) {
          result.add(Messages.PARAMETERS_POSITIVE);
        } else {
          if (!isValidPosition(
                  Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)))
              || !isValidPosition(
                  Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)))) {
            result.add(Messages.POSITION_OUTSIDE_CANVAS);
          }
        }
        if (parameters.get(4).length() != 1) {
          result.add(Messages.COLOR_ONE_CHARACTER);
        }
      } catch (NumberFormatException e) {
        result.add(String.format(Messages.NUMBER_PARAMETERS_INVALID, e.getMessage()));
      }
    }
    return result;
  }
}
