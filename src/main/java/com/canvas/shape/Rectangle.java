package com.canvas.shape;

import com.canvas.model.CanvasData;
import com.canvas.model.Point;
import java.util.List;

public class Rectangle extends BaseShape {
  private Point diagonalPoint1;
  private Point diagonalPoint2;

  @Override
  public void setParameters(List<String> parameters) {
    diagonalPoint1 =
        new Point(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
    diagonalPoint2 =
        new Point(Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)));
    setBgChar(parameters.get(4).charAt(0));
  }

  @Override
  public void draw(CanvasData canvasData) {
    int minX = Math.min(diagonalPoint1.getX(), diagonalPoint2.getX());
    int maxX = Math.max(diagonalPoint1.getX(), diagonalPoint2.getX());
    int minY = Math.min(diagonalPoint1.getY(), diagonalPoint2.getY());
    int maxY = Math.max(diagonalPoint1.getY(), diagonalPoint2.getY());

    for (int j = minX; j <= maxX; j++) {
      canvasData.getData()[diagonalPoint1.getY()][j] = getBgChar();
      canvasData.getData()[diagonalPoint2.getY()][j] = getBgChar();
    }
    for (int i = minY + 1; i <= maxY - 1; i++) {
      canvasData.getData()[i][diagonalPoint1.getX()] = getBgChar();
      canvasData.getData()[i][diagonalPoint2.getX()] = getBgChar();
    }
  }
}
