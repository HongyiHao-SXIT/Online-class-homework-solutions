import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPickerCalculator extends JFrame implements ActionListener {

    private JButton colorButton;
    private JTextField textField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public ColorPickerCalculator() {
        setTitle("Color Picker & Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel colorPanel = new JPanel();
        colorButton = new JButton("Pick Color");
        colorButton.addActionListener(this);
        colorPanel.add(colorButton);

        JPanel calculatorPanel = new JPanel();
        textField = new JTextField(10);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        calculatorPanel.add(textField);
        calculatorPanel.add(addButton);
        calculatorPanel.add(subtractButton);
        calculatorPanel.add(multiplyButton);
        calculatorPanel.add(divideButton);

        setLayout(new GridLayout(2, 1));
        add(colorPanel);
        add(calculatorPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", Color.BLACK);
            if (selectedColor != null) {
                getContentPane().setBackground(selectedColor);
            }
        } else if (e.getSource() == addButton) {
            // Perform addition operation
        } else if (e.getSource() == subtractButton) {
            // Perform subtraction operation
        } else if (e.getSource() == multiplyButton) {
            // Perform multiplication operation
        } else if (e.getSource() == divideButton) {
            // Perform division operation
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorPickerCalculator frame = new ColorPickerCalculator();
            frame.setVisible(true);
        });
    }
}