package com.canvas.validation;

import com.canvas.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineValidator extends BaseValidator {

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
          if (!validLine(
              Integer.parseInt(parameters.get(0)),
              Integer.parseInt(parameters.get(1)),
              Integer.parseInt(parameters.get(2)),
              Integer.parseInt(parameters.get(3)))) {
            result.add(Messages.LINE_INVALID);
          }
          if (!isValidPosition(
                  Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)))
              || !isValidPosition(
                  Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)))) {
            result.add(Messages.POSITION_OUTSIDE_CANVAS);
          }
          if (parameters.get(4).length() != 1) {
            result.add(Messages.COLOR_ONE_CHARACTER);
          }
        }
      } catch (NumberFormatException e) {
        result.add(String.format(Messages.NUMBER_PARAMETERS_INVALID, e.getMessage()));
      }
    }
    return result;
  }

  private boolean validLine(int x1, int y1, int x2, int y2) {
    if (x1 == x2 || y1 == y2) {
      return true;
    }
    return Math.abs(x1 - x2) == Math.abs(y1 - y2);
  }
}
