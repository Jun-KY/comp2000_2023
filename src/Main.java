import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  public static void main(String[] args) throws Exception {
    Main window = new Main();
    window.run();
  }

  class Canvas extends JPanel {
    Stage stage;

    public Canvas() throws IOException {
      setPreferredSize(new Dimension(720, 720));
      stage = StageReader.readStage("data/stage1.rvb");
    }

    @Override
    public void paint(Graphics g) {
      stage.paint(g, getMousePosition());
    }
  }

  private Main() throws IOException {
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
