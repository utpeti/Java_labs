import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setBounds(100, 100, 900, 500);
        JPanel p = new JPanel();

        int k = 5;

        for (int i = 0; i < 5; i++) {
            Virag fl = new Virag(5, 200);
            View view = new View(fl);
            p.setLayout(new GridLayout(1, k));
            p.setBounds(100 + i * 180, 300, 300, 150);
            view.setBounds(100 + i * 50, 500, 60, 150);
            p.add(view);
            new Thread(new Controller(fl, view)).start();
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setContentPane(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();

    }
}
