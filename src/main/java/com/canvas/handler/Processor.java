package com.canvas.handler;

import com.canvas.util.Util;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Processor {
  protected static final String SCRIPT_INVALID_CMD = "Invalid command. Please try again.";
  protected static final String WELCOME_SCREEN =
      """
    ╔═══════════════════════════════════════════════════════╗
    ║                                                       ║
    ║              🎨 CONSOLE CANVAS DRAWER                 ║
    ║                                                       ║
    ║      Welcome to the ASCII art canvas drawer!          ║
    ║    Create beautiful ASCII art with simple commands.   ║
    ║                                                       ║
    ║    ╭───────────────── COMMANDS ─────────────────╮     ║
    ║    │ C width height      - Create canvas        │     ║
    ║    │ P x y ch            - Draw a point         │     ║
    ║    │ L x1 y1 x2 y2 ch    - Draw a line          │     ║
    ║    │ R x1 y1 x2 y2 ch    - Draw a rectangle     │     ║
    ║    │ B x y ch            - Bucket fill          │     ║
    ║    │ HELP                - Display this help    │     ║
    ║    │ Q                   - Quit the program     │     ║
    ║    ╰────────────────────────────────────────────╯     ║
    ╚═══════════════════════════════════════════════════════╝
    """;
  protected static final String HELP_SCREEN =
      """
    > C 20 4
    ----------------------
    |                    |
    |                    |
    |                    |
    |                    |
    ----------------------
    > L 1 2 6 2 x
    ----------------------
    |                    |
    |xxxxxx              |
    |                    |
    |                    |
    ----------------------
    > R 14 1 18 3 o
    ----------------------
    |             ooooo  |
    |xxxxxx       o   o  |
    |             ooooo  |
    |                    |
    ----------------------
    > B 10 3 .
    ----------------------
    |.............ooooo..|
    |xxxxxx.......o...o..|
    |.............ooooo..|
    |....................|
    ----------------------
    > Q
    """;
  protected static final String SCRIPT_ENTER =
      "Enter your command (or type 'HELP' for assistance): ";

  private final Handler handler;
  private final Mapper mapper;

  public void process() {
    System.out.println(WELCOME_SCREEN);
    boolean exitLoop = false;
    Scanner scanner = new Scanner(System.in);
    while (!exitLoop) {
      System.out.print(SCRIPT_ENTER);
      String input = scanner.nextLine();
      System.out.println();
      switch (Util.trimStr(input).toUpperCase()) {
        case Handler.CMD_HELP -> System.out.println(HELP_SCREEN);
        case Handler.CMD_QUIT -> exitLoop = true;
        case "" -> System.out.println(SCRIPT_INVALID_CMD);
        default -> handler.handle(mapper.map(input));
      }
    }
  }
}
