import javax.swing.*;

import java.awt.*;
import java.io.*;

public class PizzaFrame extends JFrame {
    private final PizzaPanel panel;
    private final JCheckBox checkBox3, checkBox1, checkBox2, checkBox5, checkBox4;
    private final JLabel sum;
    private final JLabel ingredients;

    public PizzaFrame() throws IOException {
        setBounds(100, 200, 1280, 720);

        JPanel c = new JPanel();

        c.setLayout(new GridLayout(6, 1));
        checkBox1 = new JCheckBox("Mushroom");
        checkBox2 = new JCheckBox("Olive");
        checkBox3 = new JCheckBox("Tomato");
        checkBox4 = new JCheckBox("Corn");
        checkBox5 = new JCheckBox("Salami");
        sum = new JLabel("Sum: ");
        ingredients = new JLabel("Ingredients: ");


        c.add(checkBox1);
        c.add(checkBox2);
        c.add(checkBox3);
        c.add(checkBox4);
        c.add(checkBox5);
        c.add(sum);


        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);

        Pizza pizzaBase = new PizzaBase();
        this.panel = new PizzaPanel(pizzaBase);
        add(panel);
        add(c, BorderLayout.EAST);
        add(ingredients, BorderLayout.SOUTH);

        add(menuBar, BorderLayout.NORTH);

        openItem.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = jfc.getSelectedFile();

                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(f));
                    String line;
                    boolean ch;
                    int sor = 0;
                    while ((line = reader.readLine()) != null) {
                        sor++;
                        switch (sor) {
                            case 1 -> {
                                ch = line.equals("true");
                                checkBox1.setSelected(ch);
                            }

                            case 2 -> {
                                ch = line.equals("true");
                                checkBox2.setSelected(ch);
                            }
                            case 3 -> {
                                ch = line.equals("true");
                                checkBox3.setSelected(ch);
                            }

                            case 4 -> {
                                ch = line.equals("true");
                                checkBox4.setSelected(ch);
                            }

                            case 5 -> {
                                ch = line.equals("true");
                                checkBox5.setSelected(ch);
                            }
                        }


                    }
                    createPizza();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        saveItem.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser();

            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = jfc.getSelectedFile();
                FileWriter write = null;
                try {
                    write = new FileWriter(f);
                    PrintWriter print = new PrintWriter(write);
                    print.println(
                            checkBox1.isSelected() +
                                    "\n" +
                                    checkBox2.isSelected() +
                                    "\n" +
                                    checkBox3.isSelected() +
                                    "\n" +
                                    checkBox4.isSelected() +
                                    "\n" +
                                    checkBox5.isSelected()

                    );
                    print.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        checkBox1.addActionListener(e -> createPizza());
        checkBox2.addActionListener(e -> createPizza());
        checkBox3.addActionListener(e -> createPizza());
        checkBox4.addActionListener(e -> createPizza());
        checkBox5.addActionListener(e -> createPizza());


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void createPizza() {
        try {
            Pizza pizza = new PizzaBase();
            if (checkBox1.isSelected()) {
                pizza = new Mushroom(pizza);
            }
            if (checkBox2.isSelected()) {
                pizza = new Olive(pizza);
            }
            if (checkBox3.isSelected()) {
                pizza = new Tomato(pizza);
            }
            if (checkBox4.isSelected()) {
                pizza = new Corn(pizza);
            }
            if (checkBox5.isSelected()) {
                pizza = new Salami(pizza);
            }

            panel.setPizza(pizza);
            panel.repaint();

            sum.setText("Sum: " + pizza.getPrice());
            ingredients.setText("Ingredients: " + pizza.getIngredients());


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws IOException {

        new PizzaFrame();


    }
}
