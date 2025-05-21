package com.canvas.handler;

import com.canvas.exception.InvalidCommandException;
import com.canvas.model.CanvasData;
import com.canvas.model.CommandLine;
import com.canvas.shape.Shape;
import com.canvas.shape.ShapeType;
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
  private CanvasData canvasData;

  public void handle(CommandLine commandLine) {
    if (CMD_CREATE.equals(commandLine.getCmd())) {
      canvasData =
          new CanvasData(
              Integer.parseInt(commandLine.getParameters().getFirst()),
              Integer.parseInt(commandLine.getParameters().getLast()));
    }
    executeCmd(commandLine, canvasData);
  }

  public void executeCmd(CommandLine commandLine, CanvasData canvasData) {
    if (canvasData == null) {
      throw new InvalidCommandException(CANVAS_YET_CREATED);
    }
    Shape shape = shapeMap.get(ShapeType.fromValue(commandLine.getCmd()));
    if (shape != null) {
      drawAndDisplay(shape, canvasData, commandLine.getParameters());
    } else {
      throw new InvalidCommandException();
    }
  }

  public void drawAndDisplay(Shape shape, CanvasData canvasData, List<String> parameters) {
    shape.setParameters(parameters);
    shape.draw(canvasData);
    System.out.println(canvasData.toString());
  }
}
