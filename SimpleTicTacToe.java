import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTicTacToe extends JFrame {
    private char currentTurn = 'X'; // X starts the game
    private JButton[] buttons = new JButton[9];
    private int turnCount = 0;

    public SimpleTicTacToe() {
        setTitle("Simple Tic-Tac-Toe");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

private void initializeButtons() {
    for (int i = 0; i < 9; i++) {
        JButton button = new JButton();
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.addActionListener(e -> {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("") && !isGameOver()) {
                b.setText(String.valueOf(currentTurn));
                turnCount++;
                if (checkForWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + currentTurn + " wins!");
                    resetButtons();
                } else if (turnCount == 9) {
                    JOptionPane.showMessageDialog(null, "It's a tie!");
                    resetButtons();
                }
                currentTurn = (currentTurn == 'X') ? 'O' : 'X';
            }
        });
        buttons[i] = button;
        add(button);
    }
}


    private boolean checkForWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(buttons[i*3].getText(), buttons[i*3+1].getText(), buttons[i*3+2].getText()) ||
                checkRowCol(buttons[i].getText(), buttons[i+3].getText(), buttons[i+6].getText()))
                return true;
        }
        return checkRowCol(buttons[0].getText(), buttons[4].getText(), buttons[8].getText()) ||
               checkRowCol(buttons[2].getText(), buttons[4].getText(), buttons[6].getText());
    }

    private boolean checkRowCol(String s1, String s2, String s3) {
        return !s1.equals("") && s1.equals(s2) && s2.equals(s3);
    }

    private void resetButtons() {
        for (JButton button : buttons) {
            button.setText("");
        }
        turnCount = 0;
        currentTurn = 'X'; // X starts over
    }

    private boolean isGameOver() {
        return turnCount >= 9 || checkForWin();
    }

    public static void main(String[] args) {    
        SwingUtilities.invokeLater(() -> new SimpleTicTacToe());

    }
}
