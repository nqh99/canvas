package com.canvas.shape;

import com.canvas.model.CanvasData;
import java.util.List;

public interface Shape {
  void setParameters(List<String> parameters);

  void draw(CanvasData canvasData);
}
