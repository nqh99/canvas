package com.canvas.shape;

import com.canvas.model.CanvasData;
import java.util.List;

public class Canvas implements Shape {
  private static final Character CHAR_BLANK = ' ';
  private static final Character CHAR_MINUS = '-';
  private static final Character CHAR_VERTICAL = '|';

  private com.canvas.model.Canvas canvas;

  @Override
  public void setParameters(List<String> parameters) {
    int width = Integer.parseInt(parameters.get(0)) + 2;
    int height = Integer.parseInt(parameters.get(1)) + 2;
    canvas = new com.canvas.model.Canvas(width, height);
  }

  @Override
  public void draw(CanvasData canvasData) {
    Character[][] data = canvasData.getData();

    for (int i = 0; i < canvas.getHeight(); i++) {
      for (int j = 0; j < canvas.getWidth(); j++) {
        data[i][j] = CHAR_BLANK;
      }
    }

    for (int j = 0; j < canvas.getWidth(); j++) {
      data[0][j] = CHAR_MINUS;
      data[canvas.getHeight() - 1][j] = CHAR_MINUS;
    }

    for (int i = 1; i < canvas.getHeight() - 1; i++) {
      data[i][0] = CHAR_VERTICAL;
      data[i][canvas.getWidth() - 1] = CHAR_VERTICAL;
    }
  }
}
