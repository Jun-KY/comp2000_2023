import java.awt.Color;
import java.awt.Graphics;

class Cat extends Actor {
    public Cat(Cell position) {
        super(position);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(position.x, position.y, Cell.size, Cell.size);
    }
}