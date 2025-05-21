package com.canvas.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandLine {
  private String cmd;
  private List<String> parameters;
}
