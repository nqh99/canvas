package com.canvas.shape;

import com.canvas.model.CanvasData;
import com.canvas.model.Point;
import java.util.List;

public class Line extends BaseShape {
  private Point point1;
  private Point point2;

  @Override
  public void setParameters(List<String> parameters) {
    point1 = new Point(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
    point2 = new Point(Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)));
    setBgChar(parameters.get(4).charAt(0));
  }

  @Override
  public void draw(CanvasData canvasData) {
    if (Math.abs(point1.getX() - point2.getX()) == Math.abs(point1.getY() - point2.getY())) {
      drawDiagonalLine(canvasData);
    } else if (point1.getX() == point2.getX()) {
      drawVerticalLine(canvasData);
    } else if (point1.getY() == point2.getY()) {
      drawHorizontalLine(canvasData);
    }
  }

  private void drawHorizontalLine(CanvasData canvasData) {
    int fixedY = point1.getY();
    int minX = Math.min(point1.getX(), point2.getX());
    int maxX = Math.max(point1.getX(), point2.getX());

    for (int x = minX; x <= maxX; x++) {
      canvasData.getData()[fixedY][x] = getBgChar();
    }
  }

  private void drawVerticalLine(CanvasData canvasData) {
    int fixedX = point1.getX();
    int minY = Math.min(point1.getY(), point2.getY());
    int maxY = Math.max(point1.getY(), point2.getY());

    for (int y = minY; y <= maxY; y++) {
      canvasData.getData()[y][fixedX] = getBgChar();
    }
  }

  private void drawDiagonalLine(CanvasData canvasData) {
    Point startPoint, endPoint;
    if (point1.getX() <= point2.getX()) {
      startPoint = point1;
      endPoint = point2;
    } else {
      startPoint = point2;
      endPoint = point1;
    }

    int slopeDirection = Integer.compare(endPoint.getY(), startPoint.getY());

    for (int x = startPoint.getX(); x <= endPoint.getX(); x++) {
      int progress = x - startPoint.getX();
      int y = startPoint.getY() + slopeDirection * progress;
      if ((slopeDirection >= 0 && y <= endPoint.getY())
          || (slopeDirection < 0 && y >= endPoint.getY())) {
        canvasData.getData()[y][x] = getBgChar();
      }
    }
  }
}
