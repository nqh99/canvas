package com.canvas;

import com.canvas.configuration.Configuration;
import com.canvas.handler.Processor;

public class Main {
  public static void main(String[] args) {
    new Processor(Configuration.getInstance().getHandler(), Configuration.getInstance().getMapper())
        .process();
  }
}
