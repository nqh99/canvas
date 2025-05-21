package com.canvas.exception;

import java.io.Serial;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvalidCommandException extends IllegalArgumentException {

  @Serial private static final long serialVersionUID = 1L;
  private List<String> errorMessages;

  public InvalidCommandException(String message) {
    super(message);
  }

  public InvalidCommandException(String message, Throwable cause) {
    super(message, cause);
  }
}
