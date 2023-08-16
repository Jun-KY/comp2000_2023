import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

class Stage {
    public Grid grid;
    public List<Actor> actors;

    public Stage() {
        grid = new Grid();
        actors = new ArrayList<>();
        Cat cat = new Cat(grid.cells[0][1]);
        Dog dog = new Dog(grid.cells[0][2]);
        Bird bird = new Bird(grid.cells[0][3]);

        addActors(cat);
        addActors(dog);
        addActors(bird);
    }

    public void addActors(Actor actor) {
        actors.add(actor);
    }

    public void paint(Graphics g, Point mousePos) {
        grid.paint(g, mousePos);
        for (Actor actor : actors) {
            actor.paint(g);
        }

        // paint(g);
        // grid.paint(g, getMousePosition());

    }

}
