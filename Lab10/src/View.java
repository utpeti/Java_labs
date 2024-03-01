import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    private Virag flower;

    public View(Virag virag) throws HeadlessException {
        this.flower = virag;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.drawLine(30, 300, 30, 250 - flower.getSeed());

        g.setColor(Color.YELLOW);
        g.fillOval(30 - flower.getSeed() / 20, 250 - flower.getSeed() - flower.getSeed() / 20, flower.getSeed() / 10,
                flower.getSeed() / 10);

        setBackground(Color.orange);
    }
}
