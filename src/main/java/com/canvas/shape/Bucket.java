package com.canvas.shape;

import com.canvas.model.CanvasData;
import com.canvas.model.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bucket extends BaseShape {
  private CanvasData canvasData;
  private int x;
  private int y;

  @Override
  public void setParameters(List<String> parameters) {
    x = Integer.parseInt(parameters.get(0));
    y = Integer.parseInt(parameters.get(1));
    setBgChar(parameters.get(2).charAt(0));
  }

  @Override
  public void draw(CanvasData canvasData) {
    this.canvasData = canvasData;

    fillColor(canvasData.getData(), x, y, getBgChar());
  }

  private void fillColor(Character[][] data, int x, int y, Character newColor) {
    Character currentColor = data[y][x];
    boolean[][] hits = new boolean[canvasData.getHeight()][canvasData.getWidth()];

    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));

    while (!queue.isEmpty()) {
      Point p = queue.remove();

      if (fillColorDo(data, hits, p.getX(), p.getY(), currentColor, newColor)) {
        queue.add(new Point(p.getX(), p.getY() - 1));
        queue.add(new Point(p.getX(), p.getY() + 1));
        queue.add(new Point(p.getX() - 1, p.getY()));
        queue.add(new Point(p.getX() + 1, p.getY()));
      }
    }
  }

  private boolean fillColorDo(
      Character[][] data,
      boolean[][] hits,
      int x,
      int y,
      Character currentColor,
      Character newColor) {
    if (x < 1 || y < 1 || x > canvasData.getWidth() || y > canvasData.getHeight()) {
      return false;
    }

    if (hits[y - 1][x - 1]) {
      return false;
    }

    if (!data[y][x].equals(currentColor)) {
      return false;
    }

    data[y][x] = newColor;
    hits[y - 1][x - 1] = true;
    return true;
  }
}
