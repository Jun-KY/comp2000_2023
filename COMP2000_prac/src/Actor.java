import java.awt.Graphics;

abstract class Actor {

    // ?protected?
    Cell position;

    public Actor(Cell p) {
        this.position = p;
    }

    public abstract void paint(Graphics g);

}