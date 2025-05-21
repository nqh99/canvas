package com.canvas.shape;

import com.canvas.model.CanvasData;
import java.util.List;

public class Point extends BaseShape {
  private com.canvas.model.Point point;

  @Override
  public void setParameters(List<String> parameters) {
    point =
        new com.canvas.model.Point(
            Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
    setBgChar(parameters.get(2).charAt(0));
  }

  @Override
  public void draw(CanvasData canvasData) {
    canvasData.getData()[point.getY()][point.getX()] = getBgChar();
  }
}
