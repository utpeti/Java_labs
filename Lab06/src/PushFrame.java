import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PushFrame extends JFrame {
    public PushFrame() {
        setBounds(300, 300, 800, 800);
        setMinimumSize(new Dimension(800, 800));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton pushme = new JButton("PUSH ME!");
        pushme.setBounds(380, 380, 120, 40);
        add(pushme);

        pushme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                Random random = new Random();

                double mouseX = MouseInfo.getPointerInfo().getLocation().x;
                double mouseY = MouseInfo.getPointerInfo().getLocation().y;
                int newButtonX = random.nextInt(getContentPane().getWidth() - pushme.getWidth());
                int newButtonY = random.nextInt(getContentPane().getHeight() - pushme.getHeight());;

                if (mouseX >= pushme.getLocation().x && mouseX >= pushme.getLocation().x + pushme.getWidth() &&
                mouseY >= pushme.getLocation().y && mouseY <= pushme.getLocation().y + pushme.getHeight()) {
                    newButtonX = random.nextInt(getContentPane().getWidth() - pushme.getWidth());
                    newButtonY = random.nextInt(getContentPane().getHeight() - pushme.getHeight());
                }

                pushme.setBounds(newButtonX, newButtonY, 120, 40);
            }
        });

        setVisible(true);
    }
}
