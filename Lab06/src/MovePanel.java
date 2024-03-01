import javax.swing.*;
import java.awt.*;

public class MovePanel extends JPanel {
    private int posX, posY;

    public MovePanel() {
        posX = 200;
        posY = 200;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.PINK);
        graphics.fillOval(posX, posY, 30, 30);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        if (this.posX + posX <= 770 && this.posX + posX >= 30) {
            this.posX += posX;
        }
    }

    public void setPosY(int posY) {
        if (this.posY + posY <= 770 && this.posY + posY >= 30) {
            this.posY += posY;
        }
    }
}
