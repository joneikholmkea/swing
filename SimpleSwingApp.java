import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class SimpleSwingApp extends JFrame {
    private JButton button;
    private JLabel label;

    public SimpleSwingApp() {
        // JFrame properties
        setTitle("Simple Swing App");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and add the button
        button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello, Swing!");
            }
        });
        add(button, BorderLayout.NORTH);

        // Create and add the label
        label = new JLabel(" ", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleSwingApp().setVisible(true);
        });
    }
}
