package com.canvas.validation;

public interface Messages {
  String COMMAND_INVALID = "Command is invalid.";
  String PARAMETERS_EXPECTED = "Parameters are expected.";
  String TOO_MANY_PARAMETERS = "Command has too many parameters.";
  String MISSING_PARAMETERS = "Command has missing parameters.";
  String CANVAS_SIZE_POSITIVE = "Parameters for canvas size should be positive numbers.";
  String PARAMETERS_POSITIVE = "Parameters for position should be positive numbers.";
  String NUMBER_PARAMETERS_INVALID = "Parameters should be numbers (%s).";
  String POSITION_OUTSIDE_CANVAS = "Position is outside of canvas.";
  String COLOR_ONE_CHARACTER = "Parameter stands for color should be 1 character.";
  String LINE_INVALID = "Invalid line parameters (must be diagonal or straight).";
}
