import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Practice extends JFrame {

    public static void main(String[] args) {
        Practice window = new Practice();
        window.run();
    }

    // Cell class remains unchanged
    public class Cell extends Rectangle {
        static int size = 35;

        public Cell(int inX, int inY) {
            super(inX, inY, Cell.size, Cell.size);
        }
    }

    // Grid class remains unchanged
    public class Grid {
        Cell[][] cells = new Cell[20][20];

        public Grid() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
                }
            }
        }

        public void paint(Graphics g, Point mousePos) {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j].paint(g, mousePos);
                }
            }
        }
    }

    abstract class Actor {
        protected Cell position;

        public Actor(Cell position) {
            this.position = position;
        }

        public abstract void paint(Graphics g);
    }

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

    class Dog extends Actor {
        public Dog(Cell position) {
            super(position);
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(position.x, position.y, Cell.size, Cell.size);
        }
    }

    class Bird extends Actor {
        public Bird(Cell position) {
            super(position);
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(position.x, position.y, Cell.size, Cell.size);
        }
    }

    class Stage {
        private Grid grid;
        private List<Actor> actors;

        public Stage() {
            grid = new Grid();
            actors = new ArrayList<>();
        }

        public void addActor(Actor actor) {
            actors.add(actor);
        }

        public void paint(Graphics g) {
            grid.paint(g, null); // Assuming null for the mousePos
            for (Actor actor : actors) {
                actor.paint(g);
            }
        }
    }

    class Canvas extends JPanel {
        Stage stage = new Stage();

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            
            Cat cat = new Cat(stage.grid.cells[5][5]);
            Dog dog = new Dog(stage.grid.cells[10][10]);
            Bird bird = new Bird(stage.grid.cells[15][15]);

            stage.addActor(cat);
            stage.addActor(dog);
            stage.addActor(bird);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            stage.paint(g);
        }
    }

    private Practice() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            repaint();
        }
    }
}
