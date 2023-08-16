import java.awt.Color;
import java.awt.Graphics;

class Dog extends Actor {
    public Dog(Cell position) {
        super(position);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(position.x, position.y, Cell.size, Cell.size);
    }
}
