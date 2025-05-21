package com.canvas.handler;

import com.canvas.exception.InvalidCommandException;
import com.canvas.model.Canvas;
import com.canvas.model.CanvasData;
import com.canvas.model.CommandLine;
import com.canvas.shape.Shape;
import com.canvas.shape.ShapeType;
import com.canvas.validation.BaseValidator;
import com.canvas.validation.Messages;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Handler {
  protected static final String CMD_CREATE = "C";
  protected static final String CMD_QUIT = "Q";
  protected static final String CMD_HELP = "HELP";
  protected static final String CANVAS_YET_CREATED =
      "Canvas has not been created yet, please create canvas first.";
  private final Map<ShapeType, Shape> shapeMap;
  private final Map<ShapeType, BaseValidator> validatorMap;
  private CanvasData canvasData;

  public void handle(CommandLine commandLine) {
    try {
      validate(commandLine);
      if (CMD_CREATE.equals(commandLine.getCmd())) {
        canvasData =
            new CanvasData(
                Integer.parseInt(commandLine.getParameters().getFirst()),
                Integer.parseInt(commandLine.getParameters().getLast()));
      }
      executeCmd(commandLine, canvasData);
    } catch (InvalidCommandException e) {
      if (e.getErrorMessages() != null && !e.getErrorMessages().isEmpty()) {
        e.getErrorMessages().forEach(System.out::println);
      } else {
        System.out.println(e.getMessage());
      }
    }
  }

  public void executeCmd(CommandLine commandLine, CanvasData canvasData)
      throws InvalidCommandException {
    if (canvasData == null) {
      throw new InvalidCommandException(CANVAS_YET_CREATED);
    }
    Shape shape = shapeMap.get(ShapeType.fromValue(commandLine.getCmd()));
    if (shape != null) {
      drawAndDisplay(shape, canvasData, commandLine.getParameters());
    } else {
      throw new InvalidCommandException(Messages.COMMAND_INVALID);
    }
  }

  public void drawAndDisplay(Shape shape, CanvasData canvasData, List<String> parameters) {
    shape.setParameters(parameters);
    shape.draw(canvasData);
    System.out.println(canvasData.toString());
  }

  public void validate(CommandLine commandLine) throws InvalidCommandException {
    BaseValidator validator = validatorMap.get(ShapeType.fromValue(commandLine.getCmd()));
    if (validator != null) {
      validator.setParameters(commandLine.getParameters());
      if (canvasData != null) {
        validator.setCanvas(new Canvas(canvasData.getWidth(), canvasData.getHeight()));
      }
      List<String> result = validator.validate();
      if (!result.isEmpty()) {
        throw new InvalidCommandException(result);
      }
    } else {
      throw new InvalidCommandException(Messages.COMMAND_INVALID);
    }
  }
}
