import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    public class Cell {
        // fields
        int x;
        int y;
        static int size = 35;

        // constructors
        public Cell(int inX, int inY) {
            x = inX;
            y = inY;
        }

        // methods
        public void paint(Graphics g, Point mousePos) {
            if (contains(mousePos)) {
                g.setColor(Color.gray);
            } else {
                g.setColor(Color.white);
            }
            g.fillRect(x, y, 35, 35);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 35, 35);
        }

        public boolean contains(Point p) {
            if (p != null) {
                return x < p.x && x + size > p.x && y < p.y && y + size > p.y;

            } else {
                return false;
            }
        }
    }

    public class Grid {
        // fields
        Cell[][] cells = new Cell[20][20];

        // constructors
        public Grid() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
                }
            }
        }

        // methods
        public void paint(Graphics g, Point mousePos) {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j].paint(g, mousePos);
                }
            }
        }
    }

    class Canvas extends JPanel {
        Grid grid = new Grid();

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g) {
            // for (int i = 10; i < 710; i += 35) {
            // for (int j = 10; j < 710; j += 35) {
            // g.drawRect(i, j, 35, 35);
            // }
            // }
            grid.paint(g, getMousePosition());
        }
    }

    private Main() {
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
