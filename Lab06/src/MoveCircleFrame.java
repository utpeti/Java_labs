import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveCircleFrame extends JFrame {
    public MoveCircleFrame() {
        setBounds(100, 100, 800, 800);
        setResizable(false);
        setLayout(new BorderLayout());

        JButton north = new JButton("↑");
        JButton south = new JButton("↓");
        JButton west = new JButton("←");
        JButton east = new JButton("→");
        MovePanel centerMovePanel = new MovePanel();

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(centerMovePanel, BorderLayout.CENTER);

        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerMovePanel.setPosY(-10);
                centerMovePanel.repaint();
            }
        });

        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerMovePanel.setPosY(10);
                centerMovePanel.repaint();
            }
        });

        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerMovePanel.setPosX(-10);
                centerMovePanel.repaint();
            }
        });

        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerMovePanel.setPosX(10);
                centerMovePanel.repaint();
            }
        });

        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
