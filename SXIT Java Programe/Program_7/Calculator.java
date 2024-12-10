package Program_7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JLabel displayLabel;
    private String currentInput = "";

    public Calculator() {
        setTitle("四则运算器");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        displayLabel = new JLabel("0", SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        displayLabel.setBackground(Color.WHITE);
        displayLabel.setOpaque(true);
        displayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panel.add(displayLabel, BorderLayout.NORTH);

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(5, 3, 5, 5));

        String[] numbers = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};
        for (String number : numbers) {
            JButton button = new JButton(number);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setBackground(new Color(240, 240, 240));
            button.setFocusPainted(false);
            button.addActionListener(new NumberButtonHandler());
            numberPanel.add(button);
        }

        panel.add(numberPanel, BorderLayout.CENTER);

        JPanel functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout(1, 4, 5, 5));

        String[] operators = {"+", "-", "*", "/"};
        for (String operator : operators) {
            JButton button = new JButton(operator);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setBackground(new Color(255, 150, 100));
            button.setFocusPainted(false);
            button.addActionListener(new OperatorButtonHandler());
            functionPanel.add(button);
        }

        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 30));
        clearButton.setBackground(new Color(255, 100, 100));
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(new ClearButtonHandler());
        functionPanel.add(clearButton);

        panel.add(functionPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private class NumberButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();
            if (currentInput.equals("0")) {
                currentInput = buttonText;
            } else {
                currentInput += buttonText;
            }
            displayLabel.setText(currentInput);
        }
    }

    private class OperatorButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String operator = e.getActionCommand();
            if (!currentInput.isEmpty()) {
                currentInput += " " + operator + " ";
                displayLabel.setText(currentInput);
            }
        }
    }

    private class EqualButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String result = evaluateExpression(currentInput);
                displayLabel.setText(result);
                currentInput = result;
            } catch (Exception ex) {
                displayLabel.setText("错误");
                currentInput = "";
            }
        }
    }

    private class ClearButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentInput = "";
            displayLabel.setText("0");
        }
    }

    private String evaluateExpression(String expression) {
        try {
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");
            return String.valueOf(engine.eval(expression));
        } catch (Exception e) {
            return "错误";
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}
