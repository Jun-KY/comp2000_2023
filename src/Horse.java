import java.awt.Color;
import java.awt.Graphics;

public class Horse extends Actor {
  // Task 22
  private Motif motif;
  private static final String IMAGE_PATH = "assets/Chess_tile_nl.png";

  public Horse(Cell inLoc, Boolean isHuman) {
    super(inLoc, Color.RED, isHuman, 4);
    motif = new Motif(IMAGE_PATH);
  }

  @Override
  public void paint(Graphics g) {
    int x = this.loc.x;
    int y = this.loc.y;
    motif.draw(g, x, y, this.color);
  }

  @Override
  protected void setPoly() {
  }

}
