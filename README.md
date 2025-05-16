Console-Canvas Drawing Application
================================

Introduction
-----------------------

A small console program that imitates a very limited paint application. It supports text-based commands, draw the
requested shapes on an ASCII canvas, and show the updated canvas after every command.

Features Explained
-----------------------

1. Create a canvas  
   • Command: `C <width> <height>`  
   • The canvas is a rectangle consisting of blank pixels surrounded by a border.  
   • Width and height are positive integers (e.g. `C 20 4`).  
   • Example (20×4):

   ```
   ----------------------
   |                    |
   |                    |
   |                    |
   |                    |
   ----------------------
   ```

2. Draw primitives  
   a. Point  
   • Command: `P <x> <y> <ch>` – puts **one** character `ch` at column `x`, row `y`.  
   b. Line (horizontal or vertical)  
   • Command: `L <x1> <y1> <x2> <y2> <ch>` – draws a straight line with character `ch`.  
   • Only pure horizontal (`y1 == y2`) or vertical (`x1 == x2`) lines are required.  
   c. Rectangle / Square  
   • Command: `R <x1> <y1> <x2> <y2> <ch>` – draws the perimeter of a rectangle whose upper-left corner is `(x1, y1)`
   and lower-right corner is `(x2, y2)` using `ch`.  
   • A square is just a rectangle whose sides are equal.

3. Bucket-fill coloring  
   • Command: `B <x> <y> <ch>` – floods the canvas, starting at `(x, y)`, replacing every **contiguous** blank pixel
   with character `ch`.  
   • If `(x, y)` is already part of an existing drawing (i.e., the pixel is **not** blank), the program must still work:
   contiguous blank pixels reachable from that point’s perimeter must be filled.  
   • In other words, the command colors “all the points that haven't yet been colored” reachable from the starting
   location.

4. Quit  
   • Command: `Q` – terminates the program.

General Rules
-------------

• Coordinates start at (1, 1) in the upper-left corner **inside** the border.  
• Any attempt to draw outside the canvas or with invalid arguments must result in an explanatory error message, the
canvas should remain unchanged.  
• After successfully processing a command (except `Q`) print the whole canvas to stdout.  
• Drawing and Bucket-fill coloring are only possible after at least one C command has been executed successfully.

Sample Session
--------------

User input is prefixed with `> help`, console output follows immediately.

```
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
```
