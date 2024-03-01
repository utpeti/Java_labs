import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GroceryListFrame extends Frame {
    public GroceryListFrame() {
        setBounds(100, 100, 500, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
        setLayout(new FlowLayout());

        List fruits = new List();
        List vegetables = new List();
        Button right = new Button("->");
        Button left = new Button("<-");

        fruits.add("Apple");
        fruits.add("Pear");
        fruits.add("Melon");
        fruits.add("Watermelon");
        fruits.add("Peach");
        fruits.add("Strawberries");

        vegetables.add("Cucumber");
        vegetables.add("Pumpkin");
        vegetables.add("Eggplant");
        vegetables.add("Tomato");
        vegetables.add("Potato");

        fruits.setMultipleMode(true);
        vegetables.setMultipleMode(true);

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(String selected : fruits.getSelectedItems()) {
                    vegetables.add(selected);
                    fruits.remove(selected);
                }
            }
        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String selected : vegetables.getSelectedItems()) {
                    fruits.add(selected);
                    vegetables.remove(selected);
                }
            }
        });

        add(fruits);
        add(right);
        add(left);
        add(vegetables);

        setVisible(true);
    }
}
