package com.canvas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CanvasData {
  private int width;
  private int height;
  private Character[][] data;

  public CanvasData(int width, int height) {
    this.width = width;
    this.height = height;
    this.data = new Character[height + 2][width + 2];
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        result.append(data[i][j]);
      }
      if (i < data.length - 1) {
        result.append("\n");
      }
    }
    return result.toString();
  }
}
