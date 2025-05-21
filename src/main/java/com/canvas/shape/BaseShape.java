package com.canvas.shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseShape implements Shape {
  private Character bgChar = 'x';
}
