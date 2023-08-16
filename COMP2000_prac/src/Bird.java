import java.awt.Color;
import java.awt.Graphics;

class Bird extends Actor {
    public Bird(Cell position) {
        super(position);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(position.x, position.y, Cell.size, Cell.size);
    }
}
