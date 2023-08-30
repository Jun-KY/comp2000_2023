import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid = new Grid();
  List<Actor> actors = new ArrayList<Actor>();

  public Stage() {
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);

    for (Actor a : actors) {
      a.paint(g);
    }

    Optional<Cell> hoveredCell = grid.cellAtPoint(mouseLoc);

    int locX = grid.cells[0].length * Cell.size + 30;
    int locY = 50;

    if (hoveredCell.isPresent()) {
      Cell cell = hoveredCell.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString("Cell: " + /* String.valueOf( */cell.col/* ) */ + cell.row, locX, locY);
    } else {
      g.drawString("Outside grid", locX, locY);
    }

  }

}
