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

    int detailX = grid.cells[0].length * Cell.size + 30;
    int detailY = 50;
    if (hoveredCell.isPresent()) {
      Cell cell = hoveredCell.get();
      g.drawString("Cell: " + cell.col + cell.row, detailX, detailY);
    } else {
      g.drawString("Outside grid", detailX, detailY);
    }
  }

}
