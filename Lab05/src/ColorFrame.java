import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ColorFrame extends Frame {
    public ColorFrame() {
        setBounds(100, 100, 500, 500);
        setVisible(true);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });

        Choice choice = new Choice();
        Random random = new Random();

        choice.add("RED");
        choice.add("GREEN");
        choice.add("BLUE");
        choice.add("RANDOM");
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (choice.getSelectedItem().equals("RED")) {
                    setBackground(Color.RED);
                } else if (choice.getSelectedItem().equals("GREEN")) {
                    setBackground(Color.GREEN);
                } else if (choice.getSelectedItem().equals("BLUE")) {
                    setBackground(Color.BLUE);
                } else {
                    Color random_color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    setBackground(random_color);
                }
            }
        });

        add(choice);
    }
}
