package com.canvas.validation;

import com.canvas.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketValidator extends BaseValidator {

  @Override
  public List<String> validate() {
    List<String> result = new ArrayList<>();
    if (parameters.isEmpty()) {
      result.add(Messages.PARAMETERS_EXPECTED);
    } else if (parameters.size() > 3) {
      result.add(Messages.TOO_MANY_PARAMETERS);
    } else if (parameters.size() < 3) {
      result.add(Messages.MISSING_PARAMETERS);
    } else {
      try {
        if (!Util.isPositiveList(Arrays.asList(parameters.get(0), parameters.get(1)))) {
          result.add(Messages.PARAMETERS_POSITIVE);
        } else {
          if (!isValidPosition(
              Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)))) {
            result.add(Messages.POSITION_OUTSIDE_CANVAS);
          }
        }
      } catch (NumberFormatException e) {
        result.add(String.format(Messages.NUMBER_PARAMETERS_INVALID, e.getMessage()));
      }
      if (parameters.get(2).length() != 1) {
        result.add(Messages.COLOR_ONE_CHARACTER);
      }
    }
    return result;
  }
}
