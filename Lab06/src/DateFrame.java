import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class DateFrame extends JFrame {
    public DateFrame() {
        setBounds(100, 100, 300, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel date = new JLabel();
        JButton showDate = new JButton("SHOW CURRENT DATE");

        setLayout(new BorderLayout());
        showDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setText(LocalDateTime.now().toString());
            }
        });

        add(showDate, BorderLayout.NORTH);
        add(date, BorderLayout.SOUTH);

        setVisible(true);
    }
}
