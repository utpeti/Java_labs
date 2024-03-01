import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFilterFrame extends Frame {
    public TextFilterFrame() {
        setBounds(100, 100, 500, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
        setLayout(new FlowLayout());

        TextField textField = new TextField();
        Button filter = new Button("Filter");
        TextArea textArea = new TextArea();

        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filteredtext = textArea.getSelectedText().replace(textField.getText(), "");
                textArea.setText(filteredtext);
            }
        });

        add(textField);
        add(filter);
        add(textArea);
        setVisible(true);
    }
}
